<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template  match="/">
      <html>
         <head><title>Collection of Knives</title></head>
         <body>
         <h1><center>My Collection of Knives</center></h1>
            <table border="1">
               <tr>
                  <th>Name</th>
                  <th>Type</th>
                  <th>Handy</th>
                  <th>Origin</th>
                  <th>Blade length, mm</th>
                  <th>Blade width, mm</th>
                  <th>Blade metal</th>
                  <th>Handle material</th>
                  <th>Dol</th>
                  <th>Collection</th>
               </tr>
               <xsl:for-each select="knives/knife">
                  <tr>
                     <td><xsl:value-of select="@name"/></td>
                     <td><xsl:value-of select="knifeType"/></td>
                     <td><xsl:value-of select="handy"/></td>
                     <td><xsl:value-of select="origin"/></td>
                     <td><xsl:value-of select="visual/blade/@length"/></td>
                     <td><xsl:value-of select="visual/blade/@width"/></td>
                     <td><xsl:value-of select="visual/blade/@metal"/></td>
                     <td>
                        <!-- Write one of these items -->
                        <xsl:for-each select="visual/handle/wood">
                           <xsl:text>Wood, </xsl:text>
                           <xsl:value-of select="@type"/>
                        </xsl:for-each>
                        <xsl:for-each select="visual/handle/metal">
                           <xsl:text>Metal</xsl:text>>
                        </xsl:for-each>
                        <xsl:for-each select="visual/handle/plastic">
                           <xsl:text>Plastic</xsl:text>
                        </xsl:for-each>
                     </td>
                     <td>
                        <xsl:choose>
                           <xsl:when test="visual/dol='true'">
                              <xsl:text>yes</xsl:text>
                           </xsl:when>
                           <xsl:otherwise>
                              <xsl:text>no</xsl:text>
                           </xsl:otherwise>
                        </xsl:choose>
                     </td>
                     <td>
                        <xsl:choose>
                           <xsl:when test="collection='true'">
                              <xsl:text>yes</xsl:text>
                           </xsl:when>
                           <xsl:otherwise>
                              <xsl:text>no</xsl:text>
                           </xsl:otherwise>
                        </xsl:choose>
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>