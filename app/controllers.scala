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
    
    //TODO: urlencode
    def unbind(key:String, c:Contact) = List("id", "firstname", "name", "birthdate", "email")
                                            .zip(List(c.id, c.firstname, c.name, c.birthdate, c.email))
                                            .map(t => key + '.' + t._1 + "=" + t._2)
                                            .reduce(_ + "&" + _)
  }
  
  implicit def bindableOption[T : QueryStringBindable] = new QueryStringBindable[Option[T]] {
    def bind(key:String, params:Map[String,Seq[String]]) = implicitly[QueryStringBindable[T]].bind(key, params).map(_.right.map(Option(_)))
    def unbind(key:String, value:Option[T]) = value.map(implicitly[QueryStringBindable[T]].unbind(key, _)).getOrElse("")
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
      
      def testOption(i: Option[Int]) = Action {
        Text(i.toString)
        //save(0)
      }
      
      def create(contact: Option[Contact]) = Action {
        Text(contact.toString)
        //save(0)
      }
  }
}