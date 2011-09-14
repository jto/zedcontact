package controllers

import play.api.mvc._
import play.api.mvc.Results._

object Application extends Controller {
    import scalaz._
    import Scalaz._
        
    // TODO: do we want to get rid of this?
    // Are controllers supposed to stay pure?
    def index = Action {
        import java.util.Date
        // TODO: We can't use implicit conversion here because Html will expect an implicit Writeable
        // -- implicit def html2String(h:play.templates.Html) = h.toString
        // We either have to call toString explicitly, or provide a Writeable for play.templates.Html
        Html(views.Application.html.index(new Date()).toString)
    }
}
