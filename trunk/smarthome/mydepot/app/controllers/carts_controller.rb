class CartsController < ApplicationController

  def index
    @carts = Cart.all

    respond_to do |format|
      format.html
      format.xml {render :xml => @carts}
    end
  end
  
  def show
    begin
      @cart = Cart.find(params[:id])
    rescue ActiveRecord::RecordNotFound
      logger.error ">>> Attempt to access invalid cart #{params[:id]}"
      redirect_to store_url, :notice => "Invalid Cart"
    else
      respond_to do |format|
        format.html
        format.xml {render :xml => @cart }
      end
    end
  end

  def edit
    @cart = Cart.find(params[:id])
  end
  
  def new
    @cart = Cart.new

    respond_to do |format|
      format.html
      format.xml {render :xml => @cart }
    end
  end

  def update
    @cart = Cart.find(params[:id])
    respond_to do |format|
      if @cart.update_attributes(params[:cart])
        format.html {redirect_to(@cart, :notice => "Cart was successfully updated. ")}
        format.xml {render :ok}
      else
        format.html {render :action => "edit"}
        format.xml {render :xml => @cart.errors, :status => :unprocessable_entity }
      end
    end
  end

  def create
    @cart = Cart.new(params[:id])

    respond_to do |format|
      if @cart.save
        format.html {redirect_to(@cart, :notice => "Cart was successfully created. ")}
        format.xml {render :xml => @cart, :status => :created, :location => @cart}
      else
        format.html {render :action => "new"}
        format.xml {render :xml => @cart.errors, :status => :unprocessable_entity }
      end
    end
  end

  def destroy
    @cart = current_cart
    @cart.destroy
    session[:cart_id] = nil

    respond_to do |format|
      format.html {redirect_to(store_url)}
      format.xml {head :ok}
      format.js
    end
  end
end