// @SOURCE:/home/d2army/Documents/BetterWorks/JavaProjects/eurekaplay/conf/routes
// @HASH:49b264e1f5d22b6b4c8126f23d831cf8c7f9f22e
// @DATE:Sun Jul 22 15:12:52 PDT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:7
def complete(oauth_verifier:String) = {
   Call("GET", "/complete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("oauth_verifier", oauth_verifier)))))
}
                                                        
 
// @LINE:8
def process() = {
   Call("GET", "/process")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:11
class ReverseAssets {
    


 
// @LINE:11
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:7
def complete = JavascriptReverseRoute(
   "controllers.Application.complete",
   """
      function(oauth_verifier) {
      return _wA({method:"GET", url:"/complete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("oauth_verifier", oauth_verifier)])})
      }
   """
)
                                                        
 
// @LINE:8
def process = JavascriptReverseRoute(
   "controllers.Application.process",
   """
      function() {
      return _wA({method:"GET", url:"/process"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:11
class ReverseAssets {
    


 
// @LINE:11
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:7
def complete(oauth_verifier:String) = new play.api.mvc.HandlerRef(
   controllers.Application.complete(oauth_verifier), HandlerDef(this, "controllers.Application", "complete", Seq(classOf[String]))
)
                              
 
// @LINE:8
def process() = new play.api.mvc.HandlerRef(
   controllers.Application.process(), HandlerDef(this, "controllers.Application", "process", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:11
class ReverseAssets {
    


 
// @LINE:11
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                