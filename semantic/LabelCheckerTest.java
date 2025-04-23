import org.junit.jupiter.api.Test;
import semantic.LabelChecker;
import semantic.LabelChecker.Label;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LabelCheckerTest {

    @Test
    public void testInternalLabelConsistency_Pass() {
        Map<String, Label> userLabels = Map.of(
                "employees.age", Label.PRIVATE,
                "employees.salary", Label.PUBLIC);

        LabelChecker checker = new LabelChecker(userLabels, Map.of());
        assertTrue(checker.checkInternalLabelConsistency());
    }

    @Test
    public void testInternalLabelConsistency_Fail() {
        Map<String, Label> userLabels = Map.of(
                "employees.age", Label.PRIVATE,
                "employees.age", Label.PUBLIC // conflicting usage
        );

        LabelChecker checker = new LabelChecker(userLabels, Map.of());
        assertFalse(checker.checkInternalLabelConsistency());
    }

    @Test
    public void testBackendPolicyCompliance_Pass() {
        Map<String, Label> userLabels = Map.of(
                "employees.salary", Label.PRIVATE);
        Map<String, Label> backendLabels = Map.of(
                "employees.salary", Label.PUBLIC);

        LabelChecker checker = new LabelChecker(userLabels, backendLabels);
        assertTrue(checker.checkAgainstBackendPolicy()); // PRIVATE >= PUBLIC is OK
    }

    @Test
    public void testBackendPolicyCompliance_Fail() {
        Map<String, Label> userLabels = Map.of(
                "employees.salary", Label.PUBLIC);
        Map<String, Label> backendLabels = Map.of(
                "employees.salary", Label.PRIVATE);

        LabelChecker checker = new LabelChecker(userLabels, backendLabels);
        assertFalse(checker.checkAgainstBackendPolicy()); // PUBLIC < PRIVATE violates policy
    }

    @Test
    public void testCheckAll_Pass() {
        Map<String, Label> userLabels = Map.of(
                "employees.name", Label.PUBLIC,
                "employees.salary", Label.PRIVATE);
        Map<String, Label> backendLabels = Map.of(
                "employees.name", Label.PUBLIC,
                "employees.salary", Label.PRIVATE);

        LabelChecker checker = new LabelChecker(userLabels, backendLabels);
        assertTrue(checker.checkAll());
    }

    @Test
    public void testCheckAll_FailDueToPolicy() {
        Map<String, Label> userLabels = Map.of(
                "employees.salary", Label.PUBLIC);
        Map<String, Label> backendLabels = Map.of(
                "employees.salary", Label.PRIVATE);

        LabelChecker checker = new LabelChecker(userLabels, backendLabels);
        assertFalse(checker.checkAll());
    }
}
