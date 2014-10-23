class Notifier < ActionMailer::Base
  default :from =>"from@example.com"

  def order_received(order)
    @order = order
    mail :to => order.email, :subject =>'Pragmatic Store Order Confirmation'
  end
end