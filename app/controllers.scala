package controllers

import play.api.mvc._
import play.api.mvc.Results._

object Application extends Controller {
    import scalaz._
    import Scalaz._
    
    def index = Action {
        import java.util.Date
        Text(new Date().toString)
    }
}
