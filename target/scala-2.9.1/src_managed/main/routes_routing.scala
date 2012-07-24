// @SOURCE:/home/d2army/Documents/BetterWorks/JavaProjects/eurekaplay/conf/routes
// @HASH:49b264e1f5d22b6b4c8126f23d831cf8c7f9f22e
// @DATE:Sun Jul 22 15:12:52 PDT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_Application_complete1 = Route("GET", PathPattern(List(StaticPart("/complete"))))
                    

// @LINE:8
val controllers_Application_process2 = Route("GET", PathPattern(List(StaticPart("/process"))))
                    

// @LINE:11
val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/complete""","""controllers.Application.complete(oauth_verifier:String)"""),("""GET""","""/process""","""controllers.Application.process"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:7
case controllers_Application_complete1(params) => {
   call(params.fromQuery[String]("oauth_verifier", None)) { (oauth_verifier) =>
        invokeHandler(_root_.controllers.Application.complete(oauth_verifier), HandlerDef(this, "controllers.Application", "complete", Seq(classOf[String])))
   }
}
                    

// @LINE:8
case controllers_Application_process2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.process, HandlerDef(this, "controllers.Application", "process", Nil))
   }
}
                    

// @LINE:11
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                