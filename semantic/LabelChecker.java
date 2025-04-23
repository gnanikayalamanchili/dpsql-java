package semantic;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class LabelChecker {
    
    public enum Label {
        PUBLIC, PRIVATE;
        
        // PRIVATE is more restrictive than PUBLIC
        public boolean isMoreRestrictiveThan(Label other) {
            return this == PRIVATE && other == PUBLIC;
        }
        
        public boolean isAtLeastAsRestrictiveAs(Label other) {
            return this == other || isMoreRestrictiveThan(other);
        }
    }
    
    private final Map<String, Label> userLabels;
    private final Map<String, Label> backendLabels;
    
    public LabelChecker(Map<String, Label> userLabels, Map<String, Label> backendLabels) {
        this.userLabels = userLabels;
        this.backendLabels = backendLabels;
    }
    
    /**
     * Checks that the user hasn't assigned conflicting labels to the same column
     */
    public boolean checkInternalLabelConsistency() {
        Map<String, Set<Label>> columnLabels = new HashMap<>();
        
        for (Map.Entry<String, Label> entry : userLabels.entrySet()) {
            String column = entry.getKey();
            Label label = entry.getValue();
            
            columnLabels.computeIfAbsent(column, k -> new HashSet<>()).add(label);
        }
        
        // Check if any column has more than one label assigned
        return columnLabels.values().stream().noneMatch(labels -> labels.size() > 1);
    }
    
    /**
     * Checks that user labels comply with backend policy (user can't make columns less private)
     */
    public boolean checkAgainstBackendPolicy() {
        for (Map.Entry<String, Label> entry : userLabels.entrySet()) {
            String column = entry.getKey();
            Label userLabel = entry.getValue();
            
            if (backendLabels.containsKey(column)) {
                Label backendLabel = backendLabels.get(column);
                
                // User label must be at least as restrictive as backend label
                if (!userLabel.isAtLeastAsRestrictiveAs(backendLabel)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Runs all checks
     */
    public boolean checkAll() {
        return checkInternalLabelConsistency() && checkAgainstBackendPolicy();
    }
}