<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:variable name="newline_p1vX_p2vX_p4v1">
<xsl:text>
</xsl:text>
	</xsl:variable>

	<xsl:template name="p1vX_p2vX_p4v1">
		<xsl:param name="attributes"/>
		
		<xsl:choose>
		        <xsl:when test="/formsData/forms/form/form/@id='2.1'">
		        
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #flags: 1 #bounds: #(#{Graphics.Rectangle} 139 86 810 600)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 193 181) #label: #finishingDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 361 181) #name: #returnDateLbl #flags: 16 #label: #returnDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 186 65) #name: #reservationNumberLabel #flags: 16 #label: #reservationNumberLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 19 258) #label: #aResourceLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 106) #name: #sourcePartyLabel #label: #aSourcePartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 176) #label: #dateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 18 215) #label: #observationLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 140) #label: #aDestinationPartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 70) #label: #numberLabel) 
			#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 35 7 485 56) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 365 214) #name: #executorLabel #label: #aExecutorLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 510 10) #label: #statusLabel) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 566 11) #name: #option1RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option1Label #select: #option1) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 566 34) #name: #option2RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option2Label #select: #option2) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 566 58) #name: #option3RadioBt #flags: 48 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option3Label #select: #option3) 
			#(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 65 168 91) #name: #numberField #flags: 40 #model: #number #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 302 65 402 91) #name: #reservationNumberField #flags: 56 #model: #reservationNumber #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReservationNumber) #type: #number) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 104 104 340 129) #name: #aSourcePartyBox #flags: 40 #model: #aSourceParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allSourceParties) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 104 135 340 160) #name: #aDestinationPartyBox #flags: 40 #model: #aDestinationParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #objectListMethod: #allDestinationParties) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 169 183 195) #name: #dateField #flags: 40 #model: #date #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 270 177 348 203) #name: #finishingDateField #flags: 40 #model: #finishingDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 464 177 542 203) #name: #returnDateField #flags: 56 #model: #returnDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReturnDate #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 105 212 351 238) #name: #observationField #flags: 40 #model: #observation #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 433 213 592 238) #name: #executor #model: #aExecutor #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allExecutors) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 105 254 306 279) #name: #aResourceBox #flags: 40 #model: #aResource #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #checkResourceAvailability) #objectListMethod: #allResources) 
			#(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 410 65 532 90) #name: #reservationBt #flags: 24 #model: #searchReservation #label: #reservationBtLabel #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 355 137 397 162) #name: #destinationPartyFormOpenBt #model: #destinationPartyFormOpen #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #focusOutSelector: #refreshAllDestinationParties) #label: #(#{Kernel.UserMessage} #key: #moreBt #defaultString: 'More...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 612 212 661 237) #name: #saleBt #model: #sale #label: #(#{Kernel.UserMessage} #key: #saleBt #defaultString: 'Sale...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 319 256 361 281) #name: #resourceFormOpenBt #model: #resourceFormOpen #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #focusOutSelector: #refreshAllResources) #label: #(#{Kernel.UserMessage} #key: #moreBt #defaultString: 'More...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 569 295 639 336) #name: #paymentBt #flags: 24 #model: #payment #label: #paymentLabel #defaultable: true) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 482 109) #name: #Label2 #label: #(#{Kernel.UserMessage} #key: #printConfirmation #defaultString: '')) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 412 110 656 164) #name: #GroupBox2) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 420 132 524 155) #name: #ActionButton3 #model: #rentalConfBt #label: #(#{Kernel.UserMessage} #key: #rentalConf #defaultString: nil) #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 534 132 646 155) #name: #ActionButton1 #model: #returnConfBt #label: #(#{Kernel.UserMessage} #key: #returnConf #defaultString: nil) #defaultable: true) 


                                <xsl:if test="count(attributes/attribute)=0">
			        	#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 17 415 645 504 ) #name: #totalsCanvas #clientKey: #totalsCanvas ) 
                                </xsl:if>
					
                                <xsl:for-each select="attributes/attribute">
                                        #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 <xsl:value-of select="260 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 

                                        <xsl:if test="last()=position()">
                				#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 17 <xsl:value-of select="300 + 30 * position()"/> 645 <xsl:value-of select="390 + 30 * position()"/> ) #name: #totalsCanvas #clientKey: #totalsCanvas ) 
                                        </xsl:if>

                                </xsl:for-each>
		
        			<xsl:for-each select="attributes/attribute">
	        			<xsl:choose>
		        			<xsl:when test="type='char'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="260 + 30 * position()"/> 310 <xsl:value-of select="285 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
				        	</xsl:when>
					        <xsl:when test="type='integer'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="260 + 30 * position()"/> 310 <xsl:value-of select="285 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
	        				</xsl:when>
		        			<xsl:when test="type='float'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="260 + 30 * position()"/> 310 <xsl:value-of select="285 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
				        	</xsl:when>
					        <xsl:when test="type='date'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="260 + 30 * position()"/> 310 <xsl:value-of select="285 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
        					</xsl:when>
	        			</xsl:choose>		
                                </xsl:for-each>							
					)))		
		        </xsl:when>
		        
		        <!--___________________________________________________________________-->
		        
		        <xsl:otherwise>
			&lt;resource: #canvas&gt;
			^#(#{UI.FullSpec} #window: #(#{UI.WindowSpec} #label: #windowLabel #flags: 1 #bounds: #(#{Graphics.Rectangle} 133 86 820 600)) #component: #(#{UI.SpecCollection} #collection: #(#(#{UI.LabelSpec} #layout: #(#{Core.Point} 14 287) #label: #instanceCodeLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 191 176) #label: #finishingDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 359 176) #name: #returnDateLbl #flags: 16 #label: #returnDateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 184 60) #name: #reservationNumberLabel #flags: 16 #label: #reservationNumberLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 253) #label: #aResourceLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 101) #name: #sourcePartyLabel #label: #aSourcePartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 171) #label: #dateLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 16 210) #label: #observationLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 135) #label: #aDestinationPartyLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 15 65) #label: #numberLabel) #(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 33 2 483 51) #name: #basicBtnsCanvas #flags: 0 #clientKey: #basicBtnsCanvas) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 363 209) #name: #executorLabel #label: #aExecutorLabel) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 508 5) #label: #statusLabel) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 6) #name: #option1RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option1Label #select: #option1) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 29) #name: #option2RadioBt #flags: 32 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option2Label #select: #option2) #(#{UI.RadioButtonSpec} #layout: #(#{Core.Point} 564 53) #name: #option3RadioBt #flags: 48 #model: #status #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #label: #option3Label #select: #option3) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 488 1 635 51)) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 61 166 87) #name: #numberField #flags: 40 #model: #number #alignment: #right #type: #number) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 300 61 400 87) #name: #reservationNumberField #flags: 56 #model: #reservationNumber #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 102 100 338 125) #name: #aSourcePartyBox #flags: 40 #model: #aSourceParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allSourceParties) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 102 131 338 156) #name: #aDestinationPartyBox #flags: 40 #model: #aDestinationParty #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #objectListMethod: #allDestinationParties) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 165 181 191) #name: #dateField #flags: 40 #model: #date #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 268 173 346 199) #name: #finishingDateField #flags: 40 #model: #finishingDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 462 173 540 199) #name: #returnDateField #flags: 56 #model: #returnDate #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedReturnDate #requestFocusOutSelector: #validDate:) #type: #date #formatString: 'd-mm-yy') #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 208 349 234) #name: #observationField #flags: 40 #model: #observation #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 431 209 590 234) #name: #executor #model: #aExecutor #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #isReadOnly: false #objectListMethod: #allExecutors) #(#{GRENComboBoxSpec} #layout: #(#{Graphics.Rectangle} 103 250 304 275) #name: #aResourceBox #flags: 40 #model: #aResource #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #checkResourceAvailability) #objectListMethod: #allResources) #(#{UI.InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 285 310 311) #name: #instanceCodeField #flags: 40 #model: #instanceCode #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInstanceCode) #type: #string) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 408 60 530 85) #name: #reservationBt #flags: 24 #model: #searchReservation #label: #reservationBtLabel #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 353 132 395 157) #name: #destinationPartyFormOpenBt #model: #destinationPartyFormOpen #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #focusOutSelector: #refreshAllDestinationParties) #label: #(#{Kernel.UserMessage} #key: #moreBt #defaultString: 'More...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 610 207 659 232) #name: #saleBt #model: #sale #label: #(#{Kernel.UserMessage} #key: #saleBt #defaultString: 'Sale...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 317 251 359 276) #name: #resourceFormOpenBt #model: #resourceFormOpen #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #focusOutSelector: #refreshAllResources) #label: #(#{Kernel.UserMessage} #key: #moreBt #defaultString: 'More...') #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 567 290 637 331) #name: #paymentBt #flags: 24 #model: #payment #label: #paymentLabel #defaultable: true) #(#{UI.GroupBoxSpec} #layout: #(#{Graphics.Rectangle} 412 110 656 164) #name: #GroupBox1) #(#{UI.LabelSpec} #layout: #(#{Core.Point} 482 109) #name: #Label1 #label: #(#{Kernel.UserMessage} #key: #printConfirmation #defaultString: '')) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 420 132 524 155) #name: #ActionButton2 #model: #rentalConfBt #label: #(#{Kernel.UserMessage} #key: #rentalConf #defaultString: nil) #defaultable: true) #(#{UI.ActionButtonSpec} #layout: #(#{Graphics.Rectangle} 534 132 646 155) #name: #ActionButton3 #model: #returnConfBt #label: #(#{Kernel.UserMessage} #key: #returnConf #defaultString: nil) #defaultable: true) 
			
                                <xsl:if test="count(attributes/attribute)=0">
			        	#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 17 415 645 504 ) #name: #totalsCanvas #clientKey: #totalsCanvas ) 
                                </xsl:if>
					
                                <xsl:for-each select="attributes/attribute">
                                        #(#{UI.LabelSpec} #layout: #(#{Core.Point} 17 <xsl:value-of select="285 + 30 * position()"/>) #name: #<xsl:value-of select="name"/>Label #label: '<xsl:value-of select="uname"/>') 

                                        <xsl:if test="last()=position()">
                				#(#{UI.SubCanvasSpec} #layout: #(#{Graphics.Rectangle} 17 <xsl:value-of select="325 + 30 * position()"/> 645 <xsl:value-of select="405 + 30 * position()"/> ) #name: #totalsCanvas #clientKey: #totalsCanvas ) 
                                        </xsl:if>

                                </xsl:for-each>
		
        			<xsl:for-each select="attributes/attribute">
	        			<xsl:choose>
		        			<xsl:when test="type='char'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="285 + 30 * position()"/> 310 <xsl:value-of select="310 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData)) 
				        	</xsl:when>
					        <xsl:when test="type='integer'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="285 + 30 * position()"/> 310 <xsl:value-of select="310 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number) 
	        				</xsl:when>
		        			<xsl:when test="type='float'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="285 + 30 * position()"/> 310 <xsl:value-of select="310 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #number #formatString: '0.00') 
				        	</xsl:when>
					        <xsl:when test="type='date'">
                                                        #(#{InputFieldSpec} #layout: #(#{Graphics.Rectangle} 103 <xsl:value-of select="285 + 30 * position()"/> 310 <xsl:value-of select="310 + 30 * position()"/>) #name: #<xsl:value-of select="name"/> #model: #<xsl:value-of select="name"/> #callbacksSpec: #(#{UI.UIEventCallbackSubSpec} #valueChangeSelector: #changedInputData) #type: #date #formatString: 'd-mm-yy')
        					</xsl:when>
	        			</xsl:choose>		
                                </xsl:for-each>							
					)))		
		        </xsl:otherwise>
		</xsl:choose>


	</xsl:template>
	
</xsl:stylesheet>



