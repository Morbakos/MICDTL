<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="ISO-8859-1"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Exercice 1 - extraction de la valeur de la balise F</title>
            </head>
            <body>
                valeur des attribut nb :<xsl:for-each select="//@nb">
                <p>
                    <xsl:value-of select="."/>
                </p>
            </xsl:for-each>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="ISO-8859-1"/>
<xsl:template match="/">
    <html>
        <xsl:apply-templates select="//@nb"/>
    </html>
</xsl:template>
<xsl:template match="//@nb">
        valeur des attribut nb :
    <xsl:value-of select="."/>
</xsl:template>
</xsl:stylesheet>

<!-- Exo 2 -->
<!-- Q1 -->
<?xml version="1.0" encoding="UTF-8"?>
<examen code="C2" titre="DST_pipo">
<date jour= "20" mois="nov" annee="2012"/>
<exercice titre="Exo1">
    <question bareme="10">
        <question bareme="5">
               Quelle est la couleur du cheval blanc d’Henry IV ?
            <corrige lien="blanc.txt"/>
        </question>
        <question bareme="5">
                Qui a inventé la pile ?
            <corrige>Tesla</corrige>
        </question>
    </question>
    <question bareme="4">
            Quelle est la vitesse moyenne des courreurs cyclistes lors du tour de France, à 5km/h près ?
        <corrige>39.75</corrige>
    </question>
    <question bareme="4">
            Qui a assassiné Henri IV ?
        <corrige>Ravaillac</corrige>
    </question>
    <question bareme="2">
            Qui a construit le chateau fort du Louvre ?
        <corrige>Francois 1er</corrige>
    </question>
</exercice>
<exercice titre="Exo1">
    <question bareme="20">
        <question bareme="10">
                Quelle est la capitale du Mali ?
            <corrige>Selon Bassidiki Haidara c'est Bamako</corrige>
        </question>
        <question bareme="10">
                A quel département correspond le nombre 24 ?
            <corrige>Dordogne</corrige>
        </question>
    </question>
</exercice>
</examen>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="ISO-8859-1"/>
<xsl:template match="/">
    <html>
        <head>
            <title>Exercice 2 - Liste des questions</title>
        </head>
        <body>

            <p>Titre: <xsl:value-of select="//@titre" />
            </p>
            <p>Mois: <xsl:value-of select="//@mois" />
            </p>
            <p>Année: <xsl:value-of select="//@annee" />
            </p>

                Exercices :<xsl:for-each select="//exercice">
            <p>
                <xsl:value-of select="@titre"/>
                <p>
                        Contient les questions: 
                    <xsl:for-each select="./question">
                        <p>
                            <xsl:value-of select="./text()"/>
                        </p>
                    </xsl:for-each>
                </p>
            </p>
        </xsl:for-each>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="ISO-8859-1"/>

<xsl:template match="/">
<html>
    <xsl:apply-templates select="examen"/>
</html>
</xsl:template>

<xsl:template match="examen">
<p>
    <b>
        <xsl:value-of select="@titre"/>
    </b>
</p>
<xsl:apply-templates select="date"/>
<xsl:apply-templates select="exercice"/>
</xsl:template>

<xsl:template match="date">
<p>
    <xsl:value-of select="@jour"/>
    <xsl:value-of select="@mois"/>
    <xsl:value-of select="@annee"/>
</p>
</xsl:template>

<xsl:template match="exercice">
<xsl:value-of select="@titre"/>
<xsl:apply-templates select="question"/>
</xsl:template>

<xsl:template match="question">
<p>
    <xsl:value-of select="text()"/>
    <xsl:apply-templates select="question"/>
    <!-- pour les questions imbriquées -->
</p>
</xsl:template>

</xsl:stylesheet>

