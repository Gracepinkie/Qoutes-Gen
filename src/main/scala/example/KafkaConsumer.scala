package com.example

import cats.effect._
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import java.util.Properties
import scala.jdk.CollectionConverters._

object KafkaConsumerExample {

  def createConsumer: IO[KafkaConsumer[String, String]] = IO {
    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "quote-group")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
    new KafkaConsumer[String, String](props)
  }

  def consumeQuotes(consumer: KafkaConsumer[String, String]): IO[Unit] = IO {
    consumer.subscribe(List("quotes").asJava)
    while (true) {
      val records = consumer.poll(java.time.Duration.ofMillis(100))
      for (record <- records.asScala) {
        println(s"Consumed quote: ${record.key()} -> ${record.value()}")
      }
    }
  }
}
