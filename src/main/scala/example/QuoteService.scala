package com.example

import cats.effect.IO
import io.circe.syntax._
import io.circe.generic.auto._

import scala.util.Random

case class Quote(id: Int, text: String)

object QuoteService {
  private val quotes = List(
    Quote(1, "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela"),
    Quote(2, "The way to get started is to quit talking and begin doing. - Walt Disney"),
    Quote(3, "Don't watch the clock; do what it does. Keep going. - Sam Levenson"),
    Quote(4, "Your time is limited, don't waste it living someone else's life. - Steve Jobs")
  )

  def getRandomQuote: IO[Quote] = IO {
    quotes(Random.nextInt(quotes.size))
  }

  def getAllQuotes: IO[List[Quote]] = IO(quotes)
}
