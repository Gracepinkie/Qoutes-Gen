package com.example

import cats.effect._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.util.Properties

object KafkaProducerExample {

  def createProducer: IO[KafkaProducer[String, String]] = IO {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    new KafkaProducer[String, String](props)
  }

  def sendQuoteToKafka(producer: KafkaProducer[String, String], quote: Quote): IO[Unit] = IO {
    val record = new ProducerRecord[String, String]("quotes", quote.id.toString, quote.text)
    producer.send(record)
  }
}
