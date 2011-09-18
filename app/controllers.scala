import java.util.Date
import models._

import scalaz._
import Scalaz._

package object controllers{
  import play.core.QueryStringBindable
  implicit def bindableContact = new QueryStringBindable[models.Contact] {
    
    val fields = List("id", "firstname", "lastname", "birthdate", "email")
    
    // This crap seems overly complicated
    def bind(key:String, params:Map[String,Seq[String]]) = {
      val id = implicitly[QueryStringBindable[Option[Int]]].bind(key |+| ".id", params).orElse(some(Right(None)))
      val firstname = params.get(key |+| ".firstname").map(x => Right(x.asMA.sum))
      val lastname = params.get(key |+| ".lastname").map(x => Right(x.asMA.sum))
      val email = implicitly[QueryStringBindable[Option[String]]].bind(key |+| ".email", params).orElse(some(Right(None)))
      
      val  validated = (id |@| firstname |@| lastname |@| email){_ |@| _ |@| _ |@| _}
      validated map { v =>
        v.apply(Contact(_,_,_, new Date("09/10/1985"), _))
         .flatMap(_.either.left.map(_.sum)) //sum... bof bof
      }
    }

    //TODO: urlencode
    def unbind(key:String, c:Contact) = implicitly[QueryStringBindable[Option[Int]]].unbind(key |+| ".id", c.id) |+| 
                                          "&" |+| key |+| ".firstname=" |+| c.firstname |+|
                                          "&" |+| key |+| ".lastname=" |+| c.lastname |+|
                                          "&" |+| implicitly[QueryStringBindable[Option[String]]].unbind(key |+| ".email", c.email.map(_.value))
  }
}

package controllers{

  import play.api.mvc._
  import play.api.mvc.Results._

  object Application extends Controller {
    
      //implicit val wHtml : Writeable[play.templates.Html] = AsString[play.templates.Html](_.toString)
    
      def index = Action {
        Ok(views.Application.html.index(new Date()))
      }
    
      def edit = Action {
        Ok(views.Application.html.edit(None))
      }
    
      def save(id: Int) = Action { ctx: Context =>
        Ok(ctx.request.toString)
      }
            
      def create(contact: Option[Contact]) = Action {
        Ok(contact.toString)
        //save(0)
      }
  }
}