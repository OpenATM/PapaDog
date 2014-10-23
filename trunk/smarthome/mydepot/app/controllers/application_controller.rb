class ApplicationController < ActionController::Base
  protect_from_forgery

  private
    def current_cart
      puts "session[:cart_id]:#{session[:cart_id].class}"
      Cart.find(session[:cart_id])
    rescue ActiveRecord::RecordNotFound
      puts "---------------------------------------------------------------------"
      cart = Cart.create
      session[:cart_id] = cart.id
      cart
    end
end
