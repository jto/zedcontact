import java.util.Date
import models._

package object controllers{
  import play.core.QueryStringBindable
  implicit def bindableContact = new QueryStringBindable[models.Contact] {
    def bind(key:String, params:Map[String,Seq[String]]) = {
      Option(Right(Contact(
            42,
            "Julien",
            "Tournay",
            new Date(),
            None
      )))
    }
    def unbind(key:String, value:Contact) = "?contact.id=42"
  }
}

package controllers{

  import play.api.mvc._
  import play.api.mvc.Results._

  object Application extends Controller {
    
      implicit val wHtml : Writeable[play.templates.Html] = AsString[play.templates.Html](_.toString)
    
      def index = Action {
        Html(views.Application.html.index(new Date()))
      }
    
      def edit = Action {
        Html(views.Application.html.edit(None))
      }
    
      def save(id: Int) = Action { ctx: Context =>
        Text(ctx.request.toString)
      }
    
      def create(contact: Contact) = Action {
        save(0)
      }
  }
}