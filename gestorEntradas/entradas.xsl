<?xml version="1.0" encoding="iso-8859-1" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
	<body>
		<table frame="box" style="background-color:#77DEFF">
		<thead>
        	<tr>
				<th colspan="4" rowspan="1" bgcolor="#2E93B2" align="center" style="font-family:Helvetica;font-size:18px"> THIS IS YOUR TICKET</th>
        	</tr>
            <tr>
            	<th colspan="4"><img src="src/lib/logoPNGresize.png" style="width:50%;margin: 0 auto"/></th>
            </tr>
		</thead>
			<xsl:for-each select="entradas/entrada">
		<tbody>
				<tr>
					<td style="font-family:Helvetica">EVENTO  </td>
					<td style="font-family:Helvetica;font-size:15px;font-weight:800;"><xsl:value-of select="nombreEvento"/></td>
				</tr>
				<tr>
					<td style="font-family:Helvetica">FECHA  </td>
					<td style="font-family:Helvetica;font-size:12px"><xsl:value-of select="fecha"/></td>
                    
				</tr>
				
				<tr>	
					<td style="font-family:Helvetica">NOMBRE  </td>
					<td style="font-family:Helvetica;font-size:12px"><xsl:value-of select="nombre"/></td>
					<td style="font-family:Helvetica">APELLIDOS</td>
					<td style="font-family:Helvetica;font-size:12px"><xsl:value-of select="apellido"/></td>
				</tr>
				<tr>
					<td style="font-family:Helvetica"> LOCALIZACIÓN  </td>
					<td style="font-family:Helvetica;font-size:12px"><xsl:value-of select="localizacion"/></td>
					<td style="font-family:Helvetica"> CIUDAD  </td>
					<td style="font-family:Helvetica;font-size:12px"><xsl:value-of select="ciudad"/></td>
				</tr>
				<tr>
                    <td style="font-family:Helvetica"> PRECIO </td>
                    <td style="font-family:Helvetica;font-size:12px"><xsl:value-of select="precio"/>€</td> 
                    <td style="font-family:Helvetica;font-size:15px;font-weight:1200; color:#CE9907"><xsl:value-of select="idEntrada"/></td>
				</tr>
	</tbody>
				</xsl:for-each>
	</table>
	</body>
</html>

</xsl:template>
</xsl:stylesheet>