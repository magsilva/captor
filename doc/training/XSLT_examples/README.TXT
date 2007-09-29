
To run the examples you'll need the JDK installed on your machine.


You will be able to transform a XML source file named sources.xml with a 
template named template.xsl into an output file named out.txt just by 
executing the following command:

Ant users:

	$cd install_dir/doc/exercise/XSLT_examples/example_number
	$ant

Command line users: 

	$cd install_dir/doc/exercise/XSLT_examples/example_number
	$java -classpath ../../../../lib/xalan.jar org.apache.xalan.xslt.Process -IN source.xml -XSL template.xsl -OUT out.txt


After you read ana run the examples, you can edit and alter the contents as 
you wish to get a deep undertanding of the XSL language.

Regards.