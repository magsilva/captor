<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.org/string"
>
	<xsl:import href="lib/string.xsl" />
	<xsl:output method="text"/>
	<xsl:param name="current" />

	<xsl:variable name="appName">
		<xsl:value-of select="$current/form/data/textatt[@name='name']"/>
	</xsl:variable>

	<xsl:variable name="objectType">
		<xsl:value-of select="$current/form/data/textatt[@name='type']"/>
	</xsl:variable>

	<xsl:variable name="appPackageName">
		<xsl:call-template name="str:to-lower">
			<xsl:with-param name="text" select="$appName"/>
		</xsl:call-template>
	</xsl:variable>
	
	<xsl:template match="textatt[@name='name']">
		objs.add(new <xsl:value-of select="." />());
	</xsl:template>
	
	<xsl:template match="/">
package com.ironiacorp.games.<xsl:value-of select="$appPackageName"/>;

import java.util.ArrayList;
import java.util.List;

public class <xsl:value-of select="$appName"/>
{
	private List&lt;Instrumented<xsl:value-of select="$objectType"/>&gt; objs;

	public <xsl:value-of select="$appName"/>()
	{
		objs = new ArrayList&lt;Instrumented<xsl:value-of select="$objectType"/>&gt;();
		<xsl:apply-templates select="$current/form/form[@id='2.1']/data" />
	}
	
	public void start()
	{
		while (true) {
			// START-SAFE(simulator-engine)
			<xsl:value-of select="/data/safezone[@id='simulator-engine']" />
			/*
			Iterator&lt;InstrumentedRocket&gt; i = obj.iterator();
			while (i.hasNext()) {
				InstrumentedRocket rocket = i.next();
				System.out.println(rocket.getClass().getSimpleName() + " at " + rocket.getAltitute() + " m and " + rocket.getSpeed() + " m/s");
				if (Math.random() > 0.3) {
					double pitch = Math.random(); 
					double roll = Math.random(); 
					double yaw = Math.random(); 
					rocket.steer(pitch, roll, yaw);
				} else {
					double percent = Math.random();
					rocket.throttle(percent);
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			*/
			// END-SAFE
		}
	}
	
	public static void main(String[] args)
	{
		<xsl:value-of select="$appName"/> sim = new <xsl:value-of select="$appName"/>();
		sim.start();
	}

}
	</xsl:template>
</xsl:stylesheet>