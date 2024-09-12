import cats.effect.{IO, IOApp}
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.blaze.server.BlazeServerBuilder
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.circe._
import scala.concurrent.ExecutionContext

case class Quote(id: Int, content: String)

object Main extends IOApp.Simple {
  val quotes = List(Quote(1, "Hello World"), Quote(2, "Scala is awesome"))


  val httpApp = HttpRoutes.of[IO] {
    case GET -> Root / "quote" =>
      Ok(quotes.asJson)
  }.orNotFound

  override def run: IO[Unit] =
    BlazeServerBuilder[IO](ExecutionContext.global)
      .bindHttp(8080, "localhost")
      .withHttpApp(httpApp)
      .serve
      .compile
      .drain
}
