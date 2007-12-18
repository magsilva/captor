<?xml version="1.0"?> 

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:str="http://xsltsl.org/string">
	<xsl:import href="lib/string.xsl"/>
	<!--______________________________________________________________________-->

	<xsl:output method="text"/>

	<xsl:variable name="data">
		<xsl:value-of select="$current/form/data"/>
	</xsl:variable>

	<xsl:variable name="packageName">
	      <xsl:call-template name="replace-string"> <!-- imported template -->
        <xsl:with-param name="text" select="$current/form/data/textatt[@name='packageName']"/>
        <xsl:with-param name="replace" select="'/'"/>
        <xsl:with-param name="with" select="'.'"/>
      </xsl:call-template>
	</xsl:variable>

	<xsl:variable name="className">
		<xsl:value-of select="$current/form/data/textatt[@name='className']"/>
	</xsl:variable>
	
	<xsl:variable name="tableName">
		<xsl:value-of select="$current/form/data/textatt[@name='tableName']"/>
	</xsl:variable>
	<!--______________________________________________________________________-->

<xsl:template name="replace-string">
    <xsl:param name="text"/>
    <xsl:param name="replace"/>
    <xsl:param name="with"/>
    <xsl:choose>
      <xsl:when test="contains($text,$replace)">
        <xsl:value-of select="substring-before($text,$replace)"/>
        <xsl:value-of select="$with"/>
        <xsl:call-template name="replace-string">
          <xsl:with-param name="text" select="substring-after($text,$replace)"/>
          <xsl:with-param name="replace" select="$replace"/>
          <xsl:with-param name="with" select="$with"/>
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="$text"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>


	<!--______________________________________________________________________-->

	<xsl:template match="/">package <xsl:value-of select="$packageName"/>;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.PConnection;

public class <xsl:value-of select="$className"/>  {

  private int id;
	<xsl:for-each select="$current/form/data/table/row">
  private <xsl:value-of select="col[@number='2']/value"/><xsl:text> </xsl:text><xsl:value-of select="col[@number='0']/value"/>;</xsl:for-each>
	
  private PConnection con;
	
	public <xsl:value-of select="$current/form/data/textatt[@name='className']"/>(PConnection con)  {
		
		this.con = con;<xsl:text>
</xsl:text>
		id = 0;<xsl:text>
</xsl:text>

<xsl:for-each select="$current/form/data/table/row">
<xsl:text>		</xsl:text><xsl:value-of select="col[@number='0']/value"/><xsl:text> = </xsl:text>
    <xsl:if test="col[@number='2']/value='String'">new String();</xsl:if>
    <xsl:if test="col[@number='2']/value='int'">0;</xsl:if><xsl:text>
</xsl:text>
  </xsl:for-each>
	}	

	//getters and setters
		public int getId()  {
			return id;
		}
		public void setId(int id)  {
			this.id = id;	
		}
<xsl:for-each select="$current/form/data/table/row">
	
	<xsl:variable name="capitalAttName">
		<xsl:call-template name="str:capitalise">
			<xsl:with-param name="text" select="col[@number='0']/value"/>
			<xsl:with-param name="all" select="true()"/>
		</xsl:call-template>
	</xsl:variable>

<xsl:text>		</xsl:text>public <xsl:value-of select="col[@number='2']/value"/> get<xsl:value-of select="$capitalAttName"/>()  {
<xsl:text>			</xsl:text>return <xsl:value-of select="col[@number='0']/value"/>;
<xsl:text>		</xsl:text>}
<xsl:text>		</xsl:text>public void set<xsl:value-of select="$capitalAttName"/>(<xsl:value-of select="col[@number='2']/value"/><xsl:text> </xsl:text><xsl:value-of select="col[@number='0']/value"/>)  {
<xsl:text>			</xsl:text>this.<xsl:value-of select="col[@number='0']/value"/> = <xsl:value-of select="col[@number='0']/value"/>;	
<xsl:text>		</xsl:text>}<xsl:text>
</xsl:text>
  </xsl:for-each>

<xsl:text>//-----------------------
//presitent methods
</xsl:text>

	//persistent methods
	public boolean save()  {
		Statement stmt = null;

<xsl:variable name="tableAttStr">
<xsl:for-each select="$current/form/data/table/row">, <xsl:value-of select="col[@number='1']/value"/></xsl:for-each>
</xsl:variable>

<xsl:variable name="tableAttValuesStr">
	<xsl:for-each select="$current/form/data/table/row">
			<xsl:if test="col[@number='2']/value='String'">, <xsl:text>'</xsl:text><xsl:value-of select="col[@number='0']/value"/><xsl:text>_'</xsl:text></xsl:if>
			<xsl:if test="col[@number='2']/value='int'">, <xsl:value-of select="col[@number='0']/value"/>_</xsl:if>
	</xsl:for-each>
</xsl:variable>

		String query = "INSERT INTO <xsl:value-of select="$tableName"/> (id<xsl:value-of select="$tableAttStr"/>) VALUES (ID_<xsl:value-of select="$tableAttValuesStr"/>)";

		query = query.replaceFirst("ID_", new Integer(id).toString());
		
<xsl:for-each select="$current/form/data/table/row">
<xsl:text>		query = query.replaceFirst("</xsl:text><xsl:value-of select="col[@number='0']/value"/><xsl:text>_", </xsl:text>
<xsl:if test="col[@number='2']/value='int'">new Integer(<xsl:value-of select="col[@number='0']/value"/>).toString());</xsl:if>
<xsl:if test="col[@number='2']/value='String'"><xsl:value-of select="col[@number='0']/value"/>);</xsl:if><xsl:text>
</xsl:text>
</xsl:for-each>

		System.out.println(query);

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			try {
				stmt.close();
				return true;
			} catch (SQLException ex) { 
				System.out.println(ex);
				return false;
			}
		}catch(Exception ex)  {
  		System.out.println(ex);
			return false;
		}

	}
	
//-----------------------------------------

	public boolean getById(int id)  {
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM <xsl:value-of select="$tableName"/> WHERE ID = ID_";
		query = query.replaceFirst("ID_", new Integer(id).toString());
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next() )  {
				this.id = rs.getInt("ID");
<xsl:for-each select="$current/form/data/table/row">
<xsl:text>				</xsl:text><xsl:value-of select="col[@number='0']/value"/> = <xsl:if test="col[@number='2']/value='int'">rs.getInt("<xsl:value-of select="col[@number='1']/value"/>");</xsl:if><xsl:if test="col[@number='2']/value='String'">rs.getString("<xsl:value-of select="col[@number='1']/value"/>");</xsl:if><xsl:text>
</xsl:text></xsl:for-each>			}			
			
			try {
				stmt.close();
				return true;
			} catch (SQLException ex) { 
				System.out.println(ex);
				return false;
			}
		}catch(Exception ex)  {
			System.out.println(ex);
			return false;
		}
		
	}
	
//-----------------------------------------

	public boolean delete()  {
		Statement stmt = null;
		
		String query = "DELETE FROM <xsl:value-of select="$tableName"/> WHERE ID = ID_";
		query = query.replaceFirst("ID_", new Integer(id).toString());
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			try {
				stmt.close();
				return true;
			} catch (SQLException ex) { 
				System.out.println(ex);
				return false;
			}
		}catch(Exception ex)  {
			System.out.println(ex);
			return false;
		}
			
	}

//-----------------------------------------
	
// START-SAFE(newMethods)
<xsl:value-of select="/formsData/safezone[@id='newMethods']"/>// END-SAFE
	
}
	</xsl:template>

</xsl:stylesheet>