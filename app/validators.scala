package validators

import java.util.Date

import scalaz._
import Scalaz._


object Validators{
  def length(s: String, min: Int, max:Int = Int.MaxValue) = if (s.length < min) "too short".failNel
                                                    else if (s.length > max)"too long".failNel
                                                    else s.success
  
  def past(d: Date):ValidationNEL[String, Date] = validation(d.after(new Date()) either "Date must be in past" or d).liftFailNel
  
  def contains(s: String, c: String) = validation(!s.contains(c) either ("This string should contain: " |+| c) or s).liftFailNel
}

