# Setting Up Run/Debug Configurations in IntelliJ IDEA for DPDSL Project

This document provides step-by-step instructions for setting up Run/Debug configurations in JetBrains IntelliJ IDEA for the DPDSL (Differential Privacy-Aware SQL Language) project.

## Prerequisites

Before setting up the configurations, ensure you have:

1. JetBrains IntelliJ IDEA installed (Community or Ultimate edition)
2. The DPDSL project opened in IntelliJ IDEA
3. ANTLR4 plugin installed in IntelliJ IDEA
4. ANTLR4 runtime JAR file downloaded

## Installing ANTLR4 Plugin

1. Open IntelliJ IDEA
2. Go to `File > Settings` (or `IntelliJ IDEA > Preferences` on macOS)
3. Select `Plugins` from the left sidebar
4. Click on the `Marketplace` tab
5. Search for "ANTLR v4"
6. Click `Install` on the "ANTLR v4 grammar plugin"
7. Restart IntelliJ IDEA when prompted

## Setting Up ANTLR Grammar Generation Configuration

1. Go to `Run > Edit Configurations...`
2. Click the `+` button in the top-left corner
3. Select `ANTLR4` from the dropdown menu
4. Configure the following settings:
   - Name: `Generate DPDSL Parser`
   - Grammar file: `E:\Code\dpsql-java\grammar\DPDSL.g4` (adjust path as needed)
   - Output directory: `E:\Code\dpsql-java\grammar` (adjust path as needed)
   - Package: `grammar`
   - Language: `Java`
   - Check the following options:
     - [x] Generate parse tree visitor
     - [ ] Generate parse tree listener
   - Additional command line arguments: `-no-listener`
5. Click `OK` to save the configuration

## Setting Up Main Application Run Configuration

1. Go to `Run > Edit Configurations...`
2. Click the `+` button in the top-left corner
3. Select `Application` from the dropdown menu
4. Configure the following settings:
   - Name: `Run DPDSL`
   - Main class: `main.DPDSLRunner`
   - Program arguments: `input.dpsql` (or path to your input file)
   - Working directory: `E:\Code\dpsql-java` (adjust path as needed)
   - Use classpath of module: Select your project module
   - JRE: Select your installed JDK
   - Before launch: Add the following tasks:
     1. Click `+` > `Run Another Configuration` > Select `Generate DPDSL Parser`
     2. Click `+` > `Build`
5. Click `OK` to save the configuration

## Setting Up Test Run Configuration

1. Go to `Run > Edit Configurations...`
2. Click the `+` button in the top-left corner
3. Select `Application` from the dropdown menu
4. Configure the following settings:
   - Name: `Run DPDSL Tests`
   - Main class: `test.TestCases`
   - Working directory: `E:\Code\dpsql-java` (adjust path as needed)
   - Use classpath of module: Select your project module
   - JRE: Select your installed JDK
   - Before launch: Add the following tasks:
     1. Click `+` > `Run Another Configuration` > Select `Generate DPDSL Parser`
     2. Click `+` > `Build`
5. Click `OK` to save the configuration

## Adding ANTLR Runtime to Project Dependencies

1. Go to `File > Project Structure...`
2. Select `Modules` from the left sidebar
3. Select your project module
4. Go to the `Dependencies` tab
5. Click the `+` button and select `JARs or directories...`
6. Navigate to and select the ANTLR runtime JAR file you downloaded
7. Click `OK` to add the dependency
8. Click `Apply` and then `OK` to save the changes

## Running the Configurations

### To generate the ANTLR parser:
1. Select `Generate DPDSL Parser` from the configuration dropdown in the toolbar
2. Click the green `Run` button or press `Shift+F10`

### To run the main application:
1. Select `Run DPDSL` from the configuration dropdown in the toolbar
2. Click the green `Run` button or press `Shift+F10`

### To run the tests:
1. Select `Run DPDSL Tests` from the configuration dropdown in the toolbar
2. Click the green `Run` button or press `Shift+F10`

## Debugging

To debug any of the configurations:
1. Set breakpoints in your code by clicking in the gutter next to the line numbers
2. Select the appropriate configuration from the dropdown
3. Click the green `Debug` button or press `Shift+F9`

## Troubleshooting

If you encounter any issues:

1. **ANTLR parser generation fails**:
   - Ensure the ANTLR plugin is installed correctly
   - Check that the grammar file path is correct
   - Verify that the output directory exists and is writable

2. **Main application or tests fail to run**:
   - Ensure the ANTLR runtime JAR is correctly added to the project dependencies
   - Check that the main class is specified correctly
   - Verify that the working directory is set correctly

3. **ClassNotFoundException or NoClassDefFoundError**:
   - Ensure all required dependencies are added to the project
   - Rebuild the project by going to `Build > Rebuild Project`
   - Check that the package names in your Java files match the directory structure