
                    package views.html

                    import play.templates._
                    import play.templates.TemplateMagic._
                    
                    object index extends BaseScalaTemplate[Html,Format[Html]](HtmlFormat) {

                        def apply/*1.2*/(name:String):Html = {
                            _display_ {

format.raw/*1.15*/("""
<html>
    <head>
        <title>Home</title>
        <link rel="shortcut icon" type="image/png" href="http://www.playframework.org/public/images/favicon.png">
        <link rel="stylesheet" type="text/css" media="screen" href="/public/stylesheets/main.css"> 
    </head>
    <body>
        <h1>Hello """)+_display_(/*9.20*/name)+format.raw/*9.24*/("""!</h1>
    </body>
</html>
            """)}
                        }

                    }
 
                
                /*
                    -- GENERATED --
                    DATE: Tue Sep 13 23:26:37 CEST 2011
                    SOURCE: /Users/jto/Desktop/zedcontact/app/views/index.scala.html
                    HASH: 17bf14eeaca8ad73f135bbcf37c79f2dae98b31b
                    MATRIX: 297->1|379->14|708->317|732->321
                    LINES: 9->1|12->1|20->9|20->9
                    -- GENERATED --
                */
            