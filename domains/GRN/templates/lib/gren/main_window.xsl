<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newlineMainWindow">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<!--Exemplo:
<class>
<name><xsl:value-of select="/formsData/project/name"/>MainWindow</name>
<environment><xsl:value-of select="/formsData/project/name"/></environment>
<super>GREN.GRENApplicationMainForm</super>
<private>false</private>
<indexed-type>none</indexed-type>
<inst-vars></inst-vars>
<class-inst-vars></class-inst-vars>
<imports></imports>
<category><xsl:value-of select="/formsData/project/name"/></category>
</class>


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="/formsData/project/name"/>MainWindow class</class-id> <category>resources</category>

<body>mainMenu
	 "MenuEditor new openOnClass: self andSelector: #mainMenu"
	&lt;resource: #menu&gt;	
	^#(#{UI.Menu} #(	
				 #(#{UI.MenuItem} 
			#rawLabel: 
				#(#{Kernel.UserMessage} 
				#key:#fileOp
				#defaultString:'&amp;File' ) 
			#nameKey:file
			#submenu: #(#{UI.Menu} #( 
								  #(#{UI.MenuItem} 
					#rawLabel:
						#(#{Kernel.UserMessage} 
							#key: #exitOp 
							#defaultString:'&amp;Exit' ) 
					#nameKey: #exitOption
					#value: #exit )
						 ) #( 1) nil))
						 #(#{UI.MenuItem} 
			#rawLabel: 
				#(#{Kernel.UserMessage} 
				#key:#editOp
				#defaultString:'&amp;Edit' ) 
			#nameKey:edit
			#submenu: #(#{UI.Menu} #( 
								 #(#{UI.MenuItem} 
				     #rawLabel:'TipoProduto' 
				     #nameKey: #tipoproduto
				     #value: #tipoproduto ) 
			 #(#{UI.MenuItem} 
				     #rawLabel:'Produto' 
				     #nameKey: #produto
				     #value: #produto ) 
			 ) #(2) nil))
							 #(#{UI.MenuItem} 
			#rawLabel: 
				#(#{Kernel.UserMessage} 
				#key:#reportsOp
				#defaultString:'&amp;Reports' ) 
			#nameKey:reports
			#submenu: #(#{UI.Menu} #( 
								 ) #(0) nil))) #(4 ) nil ) decodeAsLiteralArray</body>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="/formsData/project/name"/>MainWindow class</class-id> <category>interface-specs</category>

<body>windowName
	^'<xsl:value-of select="/formsData/project/name"/>'</body>
</methods>


<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="/formsData/project/name"/>MainWindow</class-id> <category>resources</category>

<body>produto
^<xsl:value-of select="/formsData/project/name"/>.ProdutoForm openWithSpec: #singleResSpec</body>

<body>tipoproduto
^<xsl:value-of select="/formsData/project/name"/>.TipoprodutoForm openWithSpec: #tipoprodutoSpec</body>
</methods>

<methods>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="/formsData/project/name"/>MainWindow</class-id> <category>initialize-release</category>

<body>initialize
	DatabaseName :='<xsl:value-of select="/formsData/project/name"/>'.
	ReportHeader := '  F  I  T  _  0  1'.
	Language := #english.
	super initialize.</body>
</methods>
	-->
	
	<xsl:template name="main_window">
	
	<xsl:value-of select="$newlineMainWindow"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineMainWindow"/>
	<xsl:comment>-  Main Window  - </xsl:comment><xsl:value-of select="$newlineMainWindow"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineMainWindow"/>
	<xsl:value-of select="$newlineMainWindow"/>

		<xsl:value-of select="$newlineMainWindow"/>
		
<class><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
<name><xsl:value-of select="/formsData/project/name"/>MainWindow</name><xsl:value-of select="$newlineMainWindow"/>
<environment><xsl:value-of select="/formsData/project/name"/></environment><xsl:value-of select="$newlineMainWindow"/>
<super>GREN.GRENApplicationMainForm</super><xsl:value-of select="$newlineMainWindow"/>
<private>false</private><xsl:value-of select="$newlineMainWindow"/>
<indexed-type>none</indexed-type><xsl:value-of select="$newlineMainWindow"/>
<inst-vars></inst-vars><xsl:value-of select="$newlineMainWindow"/>
<class-inst-vars></class-inst-vars><xsl:value-of select="$newlineMainWindow"/>
<imports></imports><xsl:value-of select="$newlineMainWindow"/>
<category><xsl:value-of select="formsData/project/name"/></category><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
</class><xsl:value-of select="$newlineMainWindow"/>

	<xsl:value-of select="$newlineMainWindow"/>
	<xsl:comment>-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - </xsl:comment><xsl:value-of select="$newlineMainWindow"/>
	<xsl:value-of select="$newlineMainWindow"/>

<methods><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="/formsData/project/name"/>MainWindow class</class-id> <category>resources</category><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>

<body>mainMenu
	 "MenuEditor new openOnClass: self andSelector: #mainMenu"
	&lt;resource: #menu&gt;	
	^#(#{UI.Menu} #(	
				 #(#{UI.MenuItem} 
			#rawLabel: 
				#(#{Kernel.UserMessage} 
				#key:#fileOp
				#defaultString:'&amp;File' ) 
			#nameKey:file
			#submenu: #(#{UI.Menu} #( 
								  #(#{UI.MenuItem} 
					#rawLabel:
						#(#{Kernel.UserMessage} 
							#key: #exitOp 
							#defaultString:'&amp;Exit' ) 
					#nameKey: #exitOption
					#value: #exit )
						 ) #( 1) nil))
						 #(#{UI.MenuItem} 
			#rawLabel: 
				#(#{Kernel.UserMessage} 
				#key:#editOp
				#defaultString:'&amp;Edit' ) 
			#nameKey:edit
			#submenu: #(#{UI.Menu} #( 

<!--Padrao IDENTIFICAR O RECURSO / default-->
<!--___________________________________________________________________-->

		<xsl:if test="/formsData/forms/form/@variant='Default'">
			<xsl:for-each select="/formsData/forms/form/data/grenclass">
								 #(#{UI.MenuItem} 
				     #rawLabel:'<xsl:value-of select="class"/>' 
				     #nameKey: #<xsl:value-of select="class"/>
				     #value: #<xsl:value-of select="class"/> ) 

			</xsl:for-each>
		</xsl:if>

<!--Padrao IDENTIFICAR O RECURSO / Recurso sem tipo-->
<!--___________________________________________________________________-->

		<xsl:if test="/formsData/forms/form/@variant='Recurso sem tipo'">
			<xsl:for-each select="/formsData/forms/form/data/grenclass">
								 #(#{UI.MenuItem} 
				     #rawLabel:'<xsl:value-of select="class"/>' 
				     #nameKey: #<xsl:value-of select="class"/>
				     #value: #<xsl:value-of select="class"/> ) 

			</xsl:for-each>
		</xsl:if>

<!--Padrao IDENTIFICAR O RECURSO / Multiplos Recursos-->
<!--___________________________________________________________________-->


		<xsl:if test="/formsData/forms/form/@variant='Multiplos tipos'">
			<xsl:for-each select="/formsData/forms/form/data/grenclass">
				
								 #(#{UI.MenuItem} 
				     #rawLabel:'<xsl:value-of select="class"/>' 
				     #nameKey: #<xsl:value-of select="class"/>
				     #value: #<xsl:value-of select="class"/> ) 

			</xsl:for-each>
		</xsl:if>

<!--___________________________________________________________________-->

<!--Padrao ALUGAR O RECURSO / Default-->
<!--___________________________________________________________________-->


		<xsl:if test="/formsData/forms/form/form/form/@id='4.1'">
			<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">
				<xsl:if test="not(@name='Recurso')">
				
								 #(#{UI.MenuItem} 
				     #rawLabel:'<xsl:value-of select="class"/>' 
				     #nameKey: #<xsl:value-of select="class"/>
				     #value: #<xsl:value-of select="class"/> ) 
				</xsl:if>

			</xsl:for-each>
		</xsl:if>

<!--___________________________________________________________________-->

	<xsl:variable name="numMenu">
		<xsl:choose>
		  <!--  1.x->2.X->4.1  -->
			<xsl:when test="/formsData/forms/form/form/form">
				<xsl:value-of select="count(/formsData/forms/form/data/grenclass)+count(/formsData/forms/form/form/form/data/grenclass)-1"/>
			</xsl:when>
		  <!--  1.x->2.X  -->
			<xsl:otherwise>
				<xsl:value-of select="count(/formsData/forms/form/data/grenclass)"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>


			 <!--Alterar aqui para aumentar o nro de submenus-->
			 ) #(<xsl:value-of select="$numMenu"/>) nil))
							 #(#{UI.MenuItem} 
			#rawLabel: 
				#(#{Kernel.UserMessage} 
				#key:#reportsOp
				#defaultString:'&amp;Reports' ) 
			#nameKey:reports
			#submenu: #(#{UI.Menu} #( 
								 ) #(0) nil))) #(4 ) nil ) decodeAsLiteralArray</body>
</methods><xsl:value-of select="$newlineMainWindow"/>

<xsl:value-of select="$newlineMainWindow"/>
<methods><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
<class-id><xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="/formsData/project/name"/>MainWindow class</class-id> <category>interface-specs</category><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>

<body>windowName
	^'<xsl:value-of select="formsData/project/name"/>'</body><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
</methods><xsl:value-of select="$newlineMainWindow"/>

<xsl:value-of select="$newlineMainWindow"/>
<methods><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
<class-id><xsl:value-of select="formsData/project/name"/>.<xsl:value-of select="formsData/project/name"/>MainWindow</class-id> <category>resources</category><xsl:value-of select="$newlineMainWindow"/><xsl:value-of select="$newlineMainWindow"/>


<!--Padrao IDENTIFICAR O RECURSO / default-->
<!--___________________________________________________________________-->


		<xsl:if test="/formsData/forms/form/@variant='Default'">
			<xsl:for-each select="/formsData/forms/form/data/grenclass">

<xsl:value-of select="$newlineMainWindow"/>
<body><xsl:value-of select="class"/>
^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form openWithSpec: #<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineMainWindow"/>

			</xsl:for-each>
		</xsl:if>

<!--Padrao IDENTIFICAR O RECURSO / Recurso sem tipo -->
<!--___________________________________________________________________-->


		<xsl:if test="/formsData/forms/form/@variant='Recurso sem tipo'">
			<xsl:for-each select="/formsData/forms/form/data/grenclass">

<xsl:value-of select="$newlineMainWindow"/>
<body><xsl:value-of select="class"/>
^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form openWithSpec: #<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineMainWindow"/>

			</xsl:for-each>
		</xsl:if>


<!--Padrao IDENTIFICAR O RECURSO / Multiplos-->
<!--___________________________________________________________________-->


		<xsl:if test="/formsData/forms/form/@variant='Multiplos tipos'">
			<xsl:for-each select="/formsData/forms/form/data/grenclass">

<xsl:value-of select="$newlineMainWindow"/>
<body><xsl:value-of select="class"/>
^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form openWithSpec: #<xsl:value-of select="class"/>Spec</body><xsl:value-of select="$newlineMainWindow"/>

			</xsl:for-each>
		</xsl:if>

<!--___________________________________________________________________-->

<!--Padrao ALUGAR O RECURSO / Default-->
<!--___________________________________________________________________-->


		<xsl:if test="/formsData/forms/form/form/form/@id='4.1'">
			<xsl:for-each select="/formsData/forms/form/form/form/data/grenclass">

				<xsl:if test="not(@name='Recurso')">
<xsl:value-of select="$newlineMainWindow"/>
<body><xsl:value-of select="class"/>
^<xsl:value-of select="/formsData/project/name"/>.<xsl:value-of select="class"/>Form openWithSpec: <xsl:choose><xsl:when test="@name='TaxaDeMulta'">#windowSpec</xsl:when><xsl:otherwise>#<xsl:value-of select="class"/>Spec</xsl:otherwise></xsl:choose>


</body><xsl:value-of select="$newlineMainWindow"/>
				</xsl:if>

			</xsl:for-each>
		</xsl:if>

<!--___________________________________________________________________-->

<xsl:value-of select="$newlineMainWindow"/>
</methods>
<xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
<methods><xsl:value-of select="$newlineMainWindow"/>
<xsl:value-of select="$newlineMainWindow"/>
<class-id><xsl:value-of select="formsData/project/name"/>.<xsl:value-of select="formsData/project/name"/>MainWindow</class-id> <category>initialize-release</category><xsl:value-of select="$newlineMainWindow"/>

<xsl:value-of select="$newlineMainWindow"/>
<body>initialize
	DatabaseName :='<xsl:value-of select="formsData/project/name"/>'.
	ReportHeader := '<xsl:value-of select="formsData/project/name"/>'.
	Language := #english.
	super initialize.</body><xsl:value-of select="$newlineMainWindow"/>

<xsl:value-of select="$newlineMainWindow"/>	
</methods>
<xsl:value-of select="$newlineMainWindow"/>
		
	</xsl:template>


</xsl:stylesheet>
