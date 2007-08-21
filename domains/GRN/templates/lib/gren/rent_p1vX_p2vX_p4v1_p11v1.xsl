<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newline_p1vX_p2vX_p4v1_p11v1">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<xsl:template name="p1vX_p2vX_p4v1_p11v1">
        	<xsl:param name="attributes"/>
		<xsl:choose>
		        <xsl:when test="/formsData/forms/form/form/@id='2.1'">

        			&lt;resource: #canvas&gt;
        			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #flags: 1 #bounds: #(#{Graphics.Rectangle} 135 94 800 600)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 197 179) #label: #finishingDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 365 179) #name: #returnDateLbl #flags: 16 #label: #returnDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 197 70) #name: #reservationNumberLabel #flags: 16 #label: #reservationNumberLabel) 
        			
        			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 103) #name: #sourcePartyLabel #label: #aSourcePartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 173) #label: #dateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 211) #label: #observationLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 137) #label: #aDestinationPartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 67) #label: #numberLabel) 
        			#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 33 4 483 53) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 363 211) #name: #executorLabel #label: #aExecutorLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 508 7) #label: #statusLabel) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 8) #name: #option1RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option1Label #select: #option1) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 31) #name: #option2RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option2Label #select: #option2) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 55) #name: #option3RadioBt #flags: 48 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option3Label #select: #option3) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 488 3 635 53)) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 62 166 88) #name: #numberField #flags: 40 #model: #number #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 313 70 413 96) #name: #reservationNumberField #flags: 56 #model: #reservationNumber #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReservationNumber) #type: #number) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 102 101 338 126) #name: #aSourcePartyBox #flags: 40 #model: #aSourceParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allSourceParties) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 102 132 338 157) #name: #aDestinationPartyBox #flags: 40 #model: #aDestinationParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #objectListMethod: #allDestinationParties) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 169 181 195) #name: #dateField #flags: 40 #model: #date #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 273 175 351 201) #name: #finishingDateField #flags: 40 #model: #finishingDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 462 177 540 203) #name: #returnDateField #flags: 56 #model: #returnDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReturnDate #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 209 349 235) #name: #observationField #flags: 40 #model: #observation #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 431 210 590 235) #name: #executor #model: #aExecutor #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allExecutors) 
        			
        			#(#{UI.LabelSpec} #layout: #(#{Core.Point} 30 257) #label: #resourcesTransactedLabel) 
        			#(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 18 252 550 390)) 
        			#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 150 257 544 389) #name: #subcanvas #flags: 0 #clientKey: #subcanvas) 
        			
        			
        			#(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 421 70 543 95) #name: #reservationBt #flags: 24 #model: #searchReservation #label: #reservationBtLabel #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 353 134 395 159) #name: #destinationPartyFormOpenBt #model: #destinationPartyFormOpen #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #focusOutSelector: #refreshAllDestinationParties) #label: #(#{Kernel.UserMessage} #key: #moreBt #defaultString: 'More...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 610 209 659 234) #name: #saleBt #model: #sale #label: #(#{Kernel.UserMessage} #key: #saleBt #defaultString: 'Sale...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 567 292 637 333) #name: #paymentBt #flags: 24 #model: #payment #label: #paymentLabel #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 420 132 524 155) #name: #ActionButton1 #model: #rentalConfBt #label: #(#{Kernel.UserMessage} #key: #rentalConf #defaultString: nil) #defaultable: true) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 412 110 656 164) #name: #GroupBox1) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 482 109) #name: #Label1 #label: #(#{Kernel.UserMessage} #key: #printConfirmation #defaultString: '')) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 534 132 646 155) #name: #ActionButton2 #model: #returnConfBt #label: #(#{Kernel.UserMessage} #key: #returnConf #defaultString: nil) #defaultable: true) 
        			
                                <xsl:if test="count(attributes/attribute)=0">
                                        #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 16 405 641 494) #name: #totalsCanvas #clientKey: #totalsCanvas) 
                                </xsl:if>
        
        		
                                <xsl:for-each select="attributes/attribute">
                                        #(#{UI.LabelSpec} #layout: #(#{Core.Point} 20 <xsl:value-of select="370 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 
                                </xsl:for-each>
        		
        			<xsl:for-each select="attributes/attribute">
        				<xsl:choose>
        					<xsl:when test="type='char'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 <xsl:value-of select="370 + 30 * position()"/> 351 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
        					</xsl:when>
        					<xsl:when test="type='integer'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 <xsl:value-of select="370 + 30 * position()"/> 351 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
        					</xsl:when>
        					<xsl:when test="type='float'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 <xsl:value-of select="370 + 30 * position()"/> 351 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
        					</xsl:when>
        					<xsl:when test="type='date'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 <xsl:value-of select="370 + 30 * position()"/> 351 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
        					</xsl:when>
        				</xsl:choose>		
        
        			        <xsl:if test="last()=position()">
                        			#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 18 <xsl:value-of select="370 + 30 * position()+40"/> 643 <xsl:value-of select="395 + 30 * position()+100"/>) #name: #totalsCanvas #clientKey: #totalsCanvas) 
        	        		</xsl:if>
        
                                </xsl:for-each>			    
        			)))

                        </xsl:when>
		        <!--___________________________________________________________________-->
		        <xsl:otherwise>
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #flags: 1 #bounds: #(#{Graphics.Rectangle} 135 94 800 600)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 197 179) #label: #finishingDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 365 179) #name: #returnDateLbl #flags: 16 #label: #returnDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 197 70) #name: #reservationNumberLabel #flags: 16 #label: #reservationNumberLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 30 257) #label: #resourcesTransactedLabel) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 18 252 550 390)) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 103) #name: #sourcePartyLabel #label: #aSourcePartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 173) #label: #dateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 211) #label: #observationLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 137) #label: #aDestinationPartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 67) #label: #numberLabel) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 33 4 483 53) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 363 211) #name: #executorLabel #label: #aExecutorLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 508 7) #label: #statusLabel) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 8) #name: #option1RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option1Label #select: #option1) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 31) #name: #option2RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option2Label #select: #option2) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 55) #name: #option3RadioBt #flags: 48 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option3Label #select: #option3) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 488 3 635 53)) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 62 166 88) #name: #numberField #flags: 40 #model: #number #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 313 70 413 96) #name: #reservationNumberField #flags: 56 #model: #reservationNumber #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReservationNumber) #type: #number) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 102 101 338 126) #name: #aSourcePartyBox #flags: 40 #model: #aSourceParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allSourceParties) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 102 132 338 157) #name: #aDestinationPartyBox #flags: 40 #model: #aDestinationParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #objectListMethod: #allDestinationParties) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 169 181 195) #name: #dateField #flags: 40 #model: #date #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 273 175 351 201) #name: #finishingDateField #flags: 40 #model: #finishingDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 462 177 540 203) #name: #returnDateField #flags: 56 #model: #returnDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReturnDate #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 209 349 235) #name: #observationField #flags: 40 #model: #observation #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 431 210 590 235) #name: #executor #model: #aExecutor #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allExecutors) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 150 257 544 389) #name: #subcanvas #flags: 0 #clientKey: #subcanvas) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 421 70 543 95) #name: #reservationBt #flags: 24 #model: #searchReservation #label: #reservationBtLabel #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 353 134 395 159) #name: #destinationPartyFormOpenBt #model: #destinationPartyFormOpen #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #focusOutSelector: #refreshAllDestinationParties) #label: #(#{Kernel.UserMessage} #key: #moreBt #defaultString: 'More...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 610 209 659 234) #name: #saleBt #model: #sale #label: #(#{Kernel.UserMessage} #key: #saleBt #defaultString: 'Sale...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 567 292 637 333) #name: #paymentBt #flags: 24 #model: #payment #label: #paymentLabel #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 420 132 524 155) #name: #ActionButton1 #model: #rentalConfBt #label: #(#{Kernel.UserMessage} #key: #rentalConf #defaultString: nil) #defaultable: true) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 412 110 656 164) #name: #GroupBox1) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 482 109) #name: #Label1 #label: #(#{Kernel.UserMessage} #key: #printConfirmation #defaultString: '')) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 534 132 646 155) #name: #ActionButton2 #model: #returnConfBt #label: #(#{Kernel.UserMessage} #key: #returnConf #defaultString: nil) #defaultable: true) 
			
                                <xsl:if test="count(attributes/attribute)=0">
			        	#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 17 415 645 504 ) #name: #totalsCanvas #clientKey: #totalsCanvas ) 
                                </xsl:if>
					
                                <xsl:for-each select="attributes/attribute">
                                        #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 <xsl:value-of select="370 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 

                                        <xsl:if test="last()=position()">
                				#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 17 <xsl:value-of select="400 + 30 * position()"/> 645 <xsl:value-of select="490 + 30 * position()"/> ) #name: #totalsCanvas #clientKey: #totalsCanvas ) 
                                        </xsl:if>

                                </xsl:for-each>
		
        			<xsl:for-each select="attributes/attribute">
	        			<xsl:choose>
		        			<xsl:when test="type='char'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="370 + 30 * position()"/> 349 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
				        	</xsl:when>
					        <xsl:when test="type='integer'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="370 + 30 * position()"/> 349 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
	        				</xsl:when>
		        			<xsl:when test="type='float'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="370 + 30 * position()"/> 349 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
				        	</xsl:when>
					        <xsl:when test="type='date'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="370 + 30 * position()"/> 349 <xsl:value-of select="395 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
        					</xsl:when>
	        			</xsl:choose>		
                                </xsl:for-each>							
					)))		
		                       
		        </xsl:otherwise>
		        
                </xsl:choose>

	</xsl:template>
	
	                                                                                                                                                                                                                                                                                                                                      
</xsl:stylesheet>