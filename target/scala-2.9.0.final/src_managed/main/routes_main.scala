// @SOURCE:/Users/jto/Desktop/zedcontact/conf/routes
// @HASH:0098b25625426be8936cef601974755db1f92f87
// @DATE:Tue Sep 13 23:35:22 CEST 2011

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._

import Router.queryString


// @LINE:6
// @LINE:3
package controllers {

// @LINE:3
object routes_Application {
    
 
// @LINE:3
def index() = {
   Call("GET", "/")
}
                                                
    
}
                            

// @LINE:6
object routes_Assets {
    
 
// @LINE:6
def at(file:String) = {
   Call("GET", "/public/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                            

object routes {
def Application() = routes_Application
def Assets() = routes_Assets 
}

}
                    

object Routes extends Router.Routes {


// @LINE:3
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:6
val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart("/public/"), DynamicPart("file", """.+"""))))
                     
    
def routes:PartialFunction[Request,Action] = {
        

// @LINE:3
case controllers_Application_index0(params) => {
   call { 
        invokeAction(_root_.controllers.Application.index, ActionDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:6
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeAction(_root_.controllers.Assets.at(path, file), ActionDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
        
}
    
}
            