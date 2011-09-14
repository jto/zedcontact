package controllers

import play.api.mvc._
import play.api.mvc.Results._

object Application extends Controller {
    import scalaz._
    import Scalaz._
    
    implicit val wHtml : Writeable[play.templates.Html] = AsString[play.templates.Html](_.toString)
    
    // TODO: do we want to get rid of this?
    // Are controllers supposed to stay pure?
    def index = Action {
        import java.util.Date
        // We can't use implicit conversion here because Html will expect an implicit Writeable
        // We either have to call toString explicitly, or to provide a Writeable for play.templates.Html
        Html(views.Application.html.index(new Date()))
    }
}
