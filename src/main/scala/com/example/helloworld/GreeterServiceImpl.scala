package com.example.helloworld

//#import
import scala.concurrent.Future
import akka.NotUsed
import akka.actor.typed.ActorSystem
import akka.stream.scaladsl.BroadcastHub
import akka.stream.scaladsl.Keep
import akka.stream.scaladsl.MergeHub
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Source
import com.google.api.Logging

//#import

//#service-request-reply
//#service-stream
class GreeterServiceImpl()(implicit actorSystem: ActorSystem[_]) extends GreeterService {
  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    Future.successful(HelloReply(s"Hello, ${request.name}"))
  }
}

object GreeterServiceImpl {
  def apply()(implicit actorSystem: ActorSystem[_]) =
    new GreeterServiceImpl()
}
