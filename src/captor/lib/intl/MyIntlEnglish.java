/*
Copyright (C) 2005 Edison Kicho Shimabukuro Junior <edison.kicho@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package captor.lib.intl;

public class MyIntlEnglish
{
    public static void load()
    {
        MyIntl.LANG = "en";
        
        //Menus
        MyIntl.MENU_BAR_FILE = "File"; 
        MyIntl.MENU_BAR_PROJECT = "Project"; 
        MyIntl.MENU_BAR_TOOLS = "Tools"; 
        MyIntl.MENU_BAR_WINDOW = "Window"; 
        MyIntl.MENU_BAR_HELP = "Help"; 

        //SubMenus
        MyIntl.SUBMENU_BAR_NEW = "New"; 
        MyIntl.SUBMENU_BAR_EXIT = "Exit"; 
        MyIntl.SUBMENU_BAR_PROJECT = "Project"; 
        MyIntl.SUBMENU_BAR_OPEN = "Open"; 
        MyIntl.SUBMENU_BAR_CLOSE = "Close"; 
        MyIntl.SUBMENU_BAR_SAVE = "Save"; 
        MyIntl.SUBMENU_BAR_SAVEAS = "Save as"; 
        MyIntl.SUBMENU_BAR_BUILD = "Build"; 
        MyIntl.SUBMENU_BAR_CLEAN = "Clean"; 
        MyIntl.SUBMENU_BAR_VALIDATE = "Validate"; 
        MyIntl.SUBMENU_BAR_PROPERTIES = "Properties"; 
        MyIntl.SUBMENU_BAR_METAMODEL_VALIDATOR = "Metamodel validator"; 
        MyIntl.SUBMENU_BAR_NEW_WINDOW = "New Window"; 
        MyIntl.SUBMENU_BAR_SHOW_VIEW = "Show View"; 
        MyIntl.SUBMENU_BAR_PREFERENCES = "Preferences"; 
        MyIntl.SUBMENU_BAR_CONSOLE = "Console"; 
        MyIntl.SUBMENU_BAR_WARNING = "Warning"; 
        MyIntl.SUBMENU_BAR_ERROR = "Error"; 
        MyIntl.SUBMENU_BAR_CONTENTS = "Contents"; 
        MyIntl.SUBMENU_BAR_ABOUT = "About"; 

        //Header
        MyIntl.HEADER_SAVE = "Save"; 
        MyIntl.HEADER_BUILD = "Build";
        
        //Navigator bar
        MyIntl.NAVIGATOR_LABEL = " Form navigator";
        MyIntl.NAVIGATOR_ROOT_NAME = "Forms";

        //Navigator popup window menus
        MyIntl.NAVIGATOR_POPUP_NEWINTERACTION = "New interaction";
        MyIntl.NAVIGATOR_POPUP_LOAD = "Load";
        MyIntl.NAVIGATOR_POPUP_INSERT_AFTER = "Insert after";
        MyIntl.NAVIGATOR_POPUP_EDIT = "Edit";
        MyIntl.NAVIGATOR_POPUP_MOVE = "Move";
        MyIntl.NAVIGATOR_POPUP_HELP = "Help";
        
        //Navigator popup window submenus
        MyIntl.NAVIGATOR_POPUP_LOAD_VARIANT = "Load variant";
        MyIntl.NAVIGATOR_POPUP_DELETE = "Delete";
        MyIntl.NAVIGATOR_POPUP_MOVEUP= "Up";
        MyIntl.NAVIGATOR_POPUP_MOVEDOWN = "Down";
        
        //View Pane
        MyIntl.VIEW_PANE_CONSOLE = "Console";
        MyIntl.VIEW_PANE_ERROR = "Error";
        MyIntl.VIEW_PANE_WARNING = "Warning";
        
        //New project
        MyIntl.NEW_PROJECT_WINDOW_SELECT_WIZARD = "Select Wizard";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_NEW_PROJECT = "Create a new Project";
        MyIntl.NEW_PROJECT_WINDOW_WIZARDS = "Wizards";
        MyIntl.NEW_PROJECT_WINDOW_DOMAINS = "Domains";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT = "Create a Captor Project";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT_WORKSPACE = "Create a Captor project in the workspace or in a external location";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_NAME = "Project name";
        MyIntl.NEW_PROJECT_WINDOW_LOCATION = "Location";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_LAYOUT = "Project Layout";
        MyIntl.NEW_PROJECT_WINDOW_DIR = "    Directory: ";
        MyIntl.NEW_PROJECT_WINDOW_OUTPUT_DIR = "   Output folder: ";
        MyIntl.NEW_PROJECT_WINDOW_OVERWRITE = "Overwrite existing resources without warning";
        MyIntl.NEW_PROJECT_WINDOW_BROWSE = "Browse...";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_DETAILS = "Project Details";
        MyIntl.NEW_PROJECT_WINDOW_PLEASE_CHECK = "Please, check the data before press 'finish'";
        MyIntl.PROJECT_NEW = "New Project";
        
        MyIntl.NEW_PROJECT_WINDOW_PNAME = "Project name: ";
        MyIntl.NEW_PROJECT_WINDOW_PDOMAIN = "Project domain: ";
        MyIntl.NEW_PROJECT_WINDOW_PPATH = "Project path: ";
        MyIntl.NEW_PROJECT_WINDOW_PINPUT_FOLDER = "Project input folder: ";
        MyIntl.NEW_PROJECT_WINDOW_POUTPUT_FOLDER = "Project output folder: ";
        
        MyIntl.NEW_PROJECT_WINDOW_BACK = "Back";
        MyIntl.NEW_PROJECT_WINDOW_NEXT = "Next";
        MyIntl.NEW_PROJECT_WINDOW_FINISH = "Finish";
        MyIntl.NEW_PROJECT_WINDOW_CANCEL = "Cancel";
        
        //Project management windows
        MyIntl.PROJECT_PROPERTIES_WINDOW_TITLE = "Project Properties";
        MyIntl.PROJECT_FILE_DESCRIPTION = "Captor Project Files (.cap)";

        MyIntl.PROJECT_SAVEAS_TITLE = "Save Project As...";
        MyIntl.PROJECT_SAVEAS_NEW_PROJECT_HOME = "  New project name:   ";
        MyIntl.PROJECT_SAVEAS_LOCALIZACAO = "Location";
        MyIntl.PROJECT_SAVEAS_PLAYOUT = "Project Layout";
        MyIntl.PROJECT_SAVEAS_BROWSE = "Browse...";
        MyIntl.PROJECT_SAVEAS_BASE_DIR = "    Base directory: ";
        MyIntl.PROJECT_SAVEAS_OUTPUT_DIR = "   Output folder: ";

        MyIntl.PROJECT_BUILD_PROGRESS = "Build progress";
        MyIntl.PROJECT_BUILD_PWAIT = "Please wait...";
        MyIntl.PROJECT_BUILD_CANCEL = "Cancel";
        
        MyIntl.PREFERENCES_TITLE = "Options";
        MyIntl.PREFERENCES_CANCEL = "Cancel";
        MyIntl.PREFERENCES_GENERAL = "General";
        MyIntl.PREFERENCES_INSTALL_PATH = "Install Path:  ";
        MyIntl.PREFERENCES_LOOK_AND_FEEL = "Look and Feel:  ";

        //Meta-model validator
        MyIntl.METAMODEL_VALIDATOR_CLOSE = "Close";
        MyIntl.METAMODEL_VALIDATOR_BROWSE = "Browse";
        MyIntl.METAMODEL_VALIDATOR_VALIDATE = "Validate";

        //-------------------------------------------------------------------------
        //ViewPane Errors by Class source

        MyIntl.VE_XMLGENERATOR_1 = "<b><font size=\"4\">Saving project: $1</font></b><br><br>";
        MyIntl.VE_XMLGENERATOR_2 = "<font color=\"#FF9966\"><b>Starting...</b></font><br><br>";
        MyIntl.VE_XMLGENERATOR_3 = "Error.<br>Try to call toXML method to a empty form element.<br>";
        MyIntl.VE_XMLGENERATOR_4 = "<font color=\"#FF0000\"><b>Form validation error.</b></font><br><br>";
        MyIntl.VE_XMLGENERATOR_5 = "<b>Error path: </b><a href=\"$1\">$1</a><br><br>";
        MyIntl.VE_XMLGENERATOR_6 = "<b>Error message: </b><br><br>";
        MyIntl.VE_XMLGENERATOR_7 = "<font color=\"#0000FF\">$1</font><br>";
        MyIntl.VE_XMLGENERATOR_8 = "<font color=\"#808080\"><b>Generating xml from interaction: </b></font>$1<br>";
        MyIntl.VE_XMLGENERATOR_9 = "<br><font color=\"#009933\"><b>XML Generation done!</b></font><br>";
        MyIntl.VE_XMLGENERATOR_10 = "<font color=\"#808080\"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Generating xml from form: </b></font>$1<br>";
        
        MyIntl.VE_BUILDPROJECT_1 = "<b><font color=\"#FF9966\">Generation started...</font></b><br><br>";
        MyIntl.VE_BUILDPROJECT_2 = "<br><font color=\"#009933\"><b>Template generation done!</b></font><br><br>";
        MyIntl.VE_BUILDPROJECT_3 = "<br><font color=\"#009933\"><b>Generation cancelled.</b></font><br><br>";
        MyIntl.VE_BUILDPROJECT_4 = "<font color=\"#FF9999\">Cannot load source file</font> '$1 <font color=\"#FF9999\">into a DOM tree'</font>.<br>Skipping interaction: '$2'<br>";
        MyIntl.VE_BUILDPROJECT_5 = "<br><b>Transfomation mapping engine message:</b><br><font color=\"#FF0000\"><b>Cannot execute callTask:</b></font> '&lt;callTask id=\"$1\"/&gt;'<br>";
        MyIntl.VE_BUILDPROJECT_6 = "<font color=\"#FF0000\"><b>For-Each statement error:</b></font> <br><br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Statement: </b>   &lt;for-each select=\"$1\"&gt;<br><br>Cannot execute xpath selector.<br><br><b>Error Message:</b> $1 invalid format.<br>";
        MyIntl.VE_BUILDPROJECT_7 = "<b><font color=\"#FF9900\">For-Each statement WARNING:</font></b> <br><br>&nbsp;&nbsp;<b>Statement:</b> &lt;for-each select=\"$1\"&gt; in the file: $2<br><br>&nbsp;&nbsp;&nbsp;&nbsp;<b>Message:</b> Xpath selector statement hasn't returned any node.<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Action:</b> Statement ignored.";
        MyIntl.VE_BUILDPROJECT_8 = "# There were warnings in template generation.<br>See warning view for details.<br>";
        MyIntl.VE_BUILDPROJECT_9 = "<font color=\"#FF9900\"><b>If statement error: </b></font> <br><br>&nbsp;&nbsp;<b>Statement:</b> &lt;if test=\"$1\"&gt;<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Message:</b>Cannot execute test condition.<br><br>$2<br><br>Check the sintax in the template transfomation mapping file: $3 and try again.<br>";
        MyIntl.VE_BUILDPROJECT_10 = "Cannot execute task: '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_11 = "Cannot find task id = '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_12 = "Cannot find build template: '$1'.<br>Correct this error putting a valid relative file path in the 'template' tag in task tag with id = '$2'.<br>You can find examples in the documentation.<br>";
        MyIntl.VE_BUILDPROJECT_13 = "<br>Cannot execute task with id = '$1'.<br>  XPath error: $2<br><br>     Solution: <br><br>         Correct this error putting a valid expression in the 'newFilename' tag.<br><br>         You can find examples about it in the help system.<br>";
        MyIntl.VE_BUILDPROJECT_14 = "Cannot create output directory '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_15 = "Cannot create or overwrite file: '$1'. Skipping...<br>";
        MyIntl.VE_BUILDPROJECT_16 = "Cannot save file: '$1'. Skipping...<br>";
        MyIntl.VE_BUILDPROJECT_17 = "Cannot save source file '$1'.<br><br>$2";
        
        MyIntl. VE_ANTRUNNER_1 = "<b><font color=\"#FF9966\">Ant runner started...</font></b><br>";
        MyIntl. VE_ANTRUNNER_2 = "<b>Ant file:</b> $1<br>";
        MyIntl. VE_ANTRUNNER_3 = "<br><b><font color=\"#FF0000\">Ant status: error.</font></b><br><br>$1";
        MyIntl. VE_ANTRUNNER_4 = "<br><font color=\"#009933\"><b>Ant status: success.</b></font><br><br>";
        MyIntl. VE_ANTRUNNER_5 = "<br><b><font color=\"#FF0000\">Ant status: error.</font></b><br>Ant status: Cannot run default target.<br>";
        MyIntl. VE_ANTRUNNER_6 = "<font color=\"#FF0000\"><b>Cannot pre-process ant build file:</b></font>$1<br><br>";
        MyIntl. VE_ANTRUNNER_7 = "<font color=\"#FF0000\"><b>Cannot pre-process ant build file: </b></font>$1<br>";
        MyIntl. VE_ANTRUNNER_8 = "<font color=\"#FF0000\"><b>Writing permission denied.</b></font><br>";

        MyIntl.VE_BUILDUTIL_1 = "<b>Generating file:</b> ";
        MyIntl.VE_BUILDUTIL_2 = "<b>File:</b> '$1' not found .<br>$2";
        MyIntl.VE_BUILDUTIL_3 = "Exception: ";
        MyIntl.VE_BUILDUTIL_4 = "<b>Error description:</b><br><br>";
        MyIntl.VE_BUILDUTIL_5 = "<br><b>Exception name:</b> ";
        MyIntl.VE_BUILDUTIL_6 = "<b>Exception description:</b><br><br>";
        MyIntl.VE_BUILDUTIL_7 = "<br><b>Warning:</b> cannot create file: $1";
        MyIntl.VE_BUILDUTIL_8 = "<font color=\"#FF0000\"><b>Cannot transform item:</b></font><br><br>&nbsp;  <b>Source file :</b> $1.<br>&nbsp;  <b>Target file :</b> $2.<br><b>Template file :</b> $3.<br><br>";
        MyIntl.VE_BUILDUTIL_9 = "Cannot run safe-zone with source file: '$1' and new file: '$2'<br><br>$3<br>";

        MyIntl.VE_FITBODY_CARD_1 = "Variant";
        MyIntl.VE_FITBODY_CARD_2 = "Form";
        
        MyIntl.VE_EXEC_FUNCTION_1 = "If statement, test attribute is calling function: $1<br>";
        MyIntl.VE_EXEC_FUNCTION_2 = "# There were warnings in template generation. See warning view for details.<br>";
        MyIntl.VE_EXEC_FUNCTION_3 = "Cannot get XPath info from string: $1.<br><br>$2";
        MyIntl.VE_EXEC_FUNCTION_4 = "# There were warnings in template generation. See warning view for details.<br>";
        MyIntl.VE_EXEC_FUNCTION_5 = "If statement warning.<br>Cannot get XPath info from string: \"$1\".<br><br><font color=\"#FF0000\"><b>Error:</b></font><br><br>  $2.<br><br>Check this XPath syntax in the mapping transformation file.";
        
        MyIntl.VE_TAILOREXPATH_UTIL_1 = "Cannot evaluate XPath expression: '$1'.<br>";        
        
        MyIntl.VE_CLEAN_PROJECT_1 = "<br><b>Directory: $1 recursively deleted.</b>";
        MyIntl.VE_SECOND_LAYER_VALIDATOR_1 = "<a href=\"$1\">$1</a><b><font color=\"#FF0000\">Structural form validation error.</font></b><br><br><b>Form path: </b>$2<br><br><b>Error message: </b><br><br>This form requires at least $3 childs forms with name equals to: <b>$5</b><br>The current configuration have only $4 child form(s) with this name.<br><br><br>Insert the required forms to get a valid specification.<br>";
        
        MyIntl.VE_VALIDATE_PROJECT_1 = "<font color=\"#FF0000\"><b>Form validation error.</b></font><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_2 = "<b>Error path: </b><a href=\"$1\">$1</a><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_3 = "<b>Error message: </b><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_4 = "<font color=\"#0000FF\">$1</font><br>";

        MyIntl.VE_GENERAL_1 = "<br><b>Use the meta-model validator to see details.</b><br><br>";

        //-------------------------------------------------------------------------

        MyIntl.NCP_LABEL_ADD = "Add";
        MyIntl.NCP_LABEL_REMOVE = "Remove";
        MyIntl.NCP_LABEL_EDIT = "Edit";
        MyIntl.NCP_LABEL_UP = "Up";
        MyIntl.NCP_LABEL_DOWN = "Down";
        MyIntl.NCP_LABEL_HELP = "Help";
        MyIntl.NCP_LABEL_FE = "Form elements: ";
        MyIntl.NCP_LABEL_FECHOOSER = "Form element chooser";
        MyIntl.NCP_LABEL_NAME = "name";
        MyIntl.NCP_LABEL_VALUE = "value";
        MyIntl.NCP_LABEL_PARAMETERS = "Parameters: ";
        MyIntl.NCP_LABEL_ELEMENT = "Element:";
        MyIntl.NCP_LABEL_TEST = "Test";
        MyIntl.NCP_LABEL_OK = "Ok";
        MyIntl.NCP_LABEL_CANCEL = "Cancel";
        MyIntl.NCP_LABEL_FE2 = "Form element";
        MyIntl.NCP_LABEL_NAME2 = "Name: ";
        MyIntl.NCP_LABEL_VALUE2 = "Value: ";
        MyIntl.NCP_LABEL_PAR_DESC = "Parameters description";
        MyIntl.NCP_LABEL_SHOW_PAR1 = "<p><b>This element has this parameters:</b></p><br>";
        MyIntl.NCP_LABEL_SHOW_PAR2 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;Parameter name:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR3 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Parameter type:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR4 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Default value:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR5 = "<b>Regular expression:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR6 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Is required:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR7 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;Short description:</b> ";
        MyIntl.NCP_LABEL_MIN_CHILDS = "Min Childs: ";
        MyIntl.NCP_LABEL_MAX_CHILDS = "Max Childs: ";
        MyIntl.NCP_LABEL_NEXTFORMS = "Next forms: ";
        MyIntl.NCP_LABEL_NF_ERROR1 = "This element requires the 'id' parameter.\n";
        MyIntl.NCP_LABEL_PL1 = "Parameters List: ";

        //-------------------------------------------------------------------------

        //JOptionDialog Messages
        MyIntl.MSG1 = "Please, create or open a project before use de location pane.";
        MyIntl.MSG2 = "An error occurred in the template generation.\nSee error view and log view for details.";
        MyIntl.MSG3 = "There is no open project to build.";
        MyIntl.MSG4 = "The project is not saved.\nSave it first.";
        MyIntl.MSG5 = "File: $1 not found.";
        MyIntl.MSG6 = "Cannot build project.\n\nThe template directory: '$1' does not exist.";
        MyIntl.MSG7 = "Cannot build project.\nThe template directory: '$1' is not a directory.";
        MyIntl.MSG8 = "Cannot build project.\n\nThe output directory: '$1' does not exist.";
        MyIntl.MSG9 = "Cannot build project.\n\nThe output directory: '$1' is not a directory.";
        MyIntl.MSG10 = "Cannot build project.\n\nCannot write on output directory: '$1'.\nPermission denied.";
        MyIntl.MSG11 = "Cannot build project.\n\nMapper file: '$1' invalid format.";
        MyIntl.MSG12 = "Cannot build project.\n\nThe mapper file: '$1' cannot be retrieved.";
        MyIntl.MSG13 = "Errors were found int template generation!\nSee error view for details.";
        MyIntl.MSG14 = "Cannot build project.\n\nThe path: '$1' does not exist.<br>";
        MyIntl.MSG15 = "Cannot build project.\n\nThe path: '$1' is not a directory.";
        MyIntl.MSG16 = "Cannot load mapper file: ";
        MyIntl.MSG17 = "Build error.\nSee error view for details.";
        MyIntl.MSG18 = "Cannot load the source file.\n";
        MyIntl.MSG19 = "There is no open project to clean.";
        MyIntl.MSG20 = "Cannot clean project.\nThe output directory: $1 does not exist.";
        MyIntl.MSG21 = "Cannot clean project.\nThe output directory: $1 is not a directory.";
        MyIntl.MSG22 = "Cannot clean project.\n\nThe output directory: $1 cannot be deleted.";
        MyIntl.MSG23 = "Files removed.\nSee console view for details.";
        MyIntl.MSG24 = "There is no project files to be removed.";
        MyIntl.MSG25 = "There is no project loaded by the project manager.";
        MyIntl.MSG26 = "There is no project loaded by the project manager.";
        MyIntl.MSG27 = "The current project was not saved.\nSave project before close it?";
        MyIntl.MSG28 = "Close Project";
        MyIntl.MSG29 = "Project $1 closed.";
        MyIntl.MSG30 = "Project file not found.";
        MyIntl.MSG31 = "Cannot load project.\nSee error view for details.";
        MyIntl.MSG32 = "There is no open project to build.";
        MyIntl.MSG33 = "The project was not saved.\nTo build the project is necessary save it first.\nSave the project?";
        MyIntl.MSG34 = "Build Project";
        MyIntl.MSG35 = "Validation completed successfully.";
        MyIntl.MSG36 = "There is no project loaded by the project manager.";
        MyIntl.MSG37 = "There is no project to save.";
        MyIntl.MSG38 = "There project is already saved.";
        MyIntl.MSG39 = "Validation error.\nSee error view for details.";
        MyIntl.MSG40 = "Cannot save project.\nThe file: $1 doesn't exists.";
        MyIntl.MSG41 = "Cannot save project.\nIOException while clean the input folder.\n$1";
        MyIntl.MSG42 = "Cannot save project.\nMsg: \n\n    $1";
        MyIntl.MSG43 = "There is no open project to save as.";
        MyIntl.MSG44 = "There directory $1 already exist.\nThis tool will not overwrite the contents of this directory with the project files.\nPlease choose another directory or first move $1 to somewhere else.";
        MyIntl.MSG45 = "The current project was not saved. Save project?";
        MyIntl.MSG46 = "Save As";
        MyIntl.MSG47 = "Action canceled.";
        MyIntl.MSG48 = "Error.\nCannot create directory: $1";
        MyIntl.MSG49 = "Error.\nCannot open: $1";
        MyIntl.MSG50 = "Error.\nCannot copy directory $1 to $2.";
        MyIntl.MSG51 = "Error.\nCannot create: $1";
        MyIntl.MSG52 = "Error.\nCannot create directory: $1";
        MyIntl.MSG53 = "Project created.\nDo you want to open the project?";
        MyIntl.MSG54 = "There is no open project to validate.";
        MyIntl.MSG55 = "Validation error.\nSee error view for details.";
        MyIntl.MSG56 = "Validation error.\nSee error view for details.";
        MyIntl.MSG57 = "Project saved.";
        MyIntl.MSG58 = "Cannot instantiate class: $1";
        MyIntl.MSG59 = "         Error - There are missing required parameters.\nCorrection - Put the required missing parameres in the parameres list.\n\n           Tip -  See individual form component documentation for required parameters details.\n";
        MyIntl.MSG60 = "Error.\nThe id field is blank.";
        MyIntl.MSG61 = "The id field doesn't match the regular expression: $1.";
        MyIntl.MSG62 = "The 'min childs' field value must be a number greater than -1.";
        MyIntl.MSG63 = "The 'min childs' field value must be a number greater than -1.";
        MyIntl.MSG64 = "The 'max childs' field value must be a number greater than '1' or the string 'N'.";
        MyIntl.MSG65 = "The 'max childs' field value must be a number or the string 'N'.";
        MyIntl.MSG66 = "The id panel cannot be blank.";
        MyIntl.MSG67 = "The require list needs at least 1 item.";
        MyIntl.MSG68 = "This path already exists in the path list.";
        MyIntl.MSG69 = "The column $1 has a empty value.";
        MyIntl.MSG70 = "HelpSet not found";
        MyIntl.MSG71 = "Error";
        MyIntl.MSG72 = "Could not create HelpSet for $1";
        MyIntl.MSG73 = "Cannot create URL for $1";
        MyIntl.MSG74 = "Cannot delete root form: $1";
        MyIntl.MSG75 = "Are you sure that tou want to delete form: \"$1\"?";
        MyIntl.MSG76 = "Delete Form";
        MyIntl.MSG77 = "This node can only have $1 $2 childs.";
        MyIntl.MSG78 = "There is no help available for this form.";
        MyIntl.MSG79 = "Cannot delete this form.\nIt's parent ($1) requires at least $2 \"$3\" childs.";
        MyIntl.MSG80 = "There is no open project to save as.";
        MyIntl.MSG81 = "Project creation cancelled.";
        MyIntl.MSG82 = "Cannot find form: ";
        MyIntl.MSG83 = "The application cannot work properly because you have no writing permission to: $1.\nCorrect this error and try again.";
        MyIntl.MSG84 = "Meta-model validation ok.";
        MyIntl.MSG85 = "An error in the meta-model were found. See MMV window for details.";
        MyIntl.MSG86 = "The project name contain a invalid character.";
        MyIntl.MSG87 = "Invalid project name.\nThe fist letter must be in upper case form.";
        MyIntl.MSG88 = "Invalid project name.\nIt doesn't match the regular expression: $1";
        MyIntl.MSG89 = "Please, select a domain before press 'next'.";
        MyIntl.MSG90 = "Build complete!";
        MyIntl.MSG91 = "Build cancelled.";

        //NCPMessages
        MyIntl.MSG92 = "Are you sure that you want to removes this item?";
        MyIntl.MSG93 = "Remove form element";
        MyIntl.MSG94 = "You've requested a change in the element's list.\nWould you like to remove all parameters from the parameters list and load the required parameters to the new element?";
        MyIntl.MSG95 = "Change element";
        MyIntl.MSG96 = "Select a row first.";
        MyIntl.MSG97 = "Select a element in the combo box to test.";
        MyIntl.MSG98 = "Please, select a form element in the combo box before press 'Ok' button.";
        MyIntl.MSG99 = "The parameter list contains parameters that will not be used by the element.\nThese parameters will be ignored by the tool at runtime.\n\nUnused parameteres:\n\n";
        MyIntl.MSG100 = "\n\nDo you want to proceed?";
        MyIntl.MSG101 = "Unused parameters detected";
        MyIntl.MSG102 = "Cannot remove parameter.\nThe parameter that you're trying to remove have a required use in this element.";
        MyIntl.MSG103 = "The name cannot be blank.";
        MyIntl.MSG104 = "The value cannot be blank.";
        MyIntl.MSG105 = "Cannot get element instance.\n\n";
        MyIntl.MSG106 = "Cannot get form element instance: $1.\n\n$2";
        MyIntl.MSG107 = "The 'Max Childs' value must be greather or equals to 'Min Childs' value.";
        MyIntl.MSG108 = "You've selected a auto-relation next form node (the next form node points to itself).\nYou cannot select a 'min childs' value different than '0'.";
        MyIntl.MSG109 = "The next form list already contain the selected 'New Form' node.";
        MyIntl.MSG110 = "Are you sure that you want to removes this item?";
        MyIntl.MSG111 = "Remove next form";
        MyIntl.MSG112 = "You should select a \"New Form\" node in the form tree.";
        MyIntl.MSG113 = "The form require at least one form element.\n    Add a form component in the form indicated above.";
        MyIntl.MSG114 = "Please, select a forrm element in the combo box before add a new parameter.";
        MyIntl.MSG115 = "Cannot find next form element.";
    }
}
