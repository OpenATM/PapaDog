class StoreController < ApplicationController

  def index
    if params[:set_locale]
      redirect_to store_path(:locale => params[:set_locale])
    else
      @cart = current_cart
    end

    if params[:locale]
      @products = Product.where(:locale => params[:locale], :active => true)
    else
      @products = Product.all_active
    end

    if session[:counter].nil?
      session[:counter] = 0
    end
    session[:counter] = session[:counter] + 1
  end
  
end