class OrdersController < ApplicationController

  def index
     @orders = Order.paginate :page => params[:page], :order => 'created_at desc', :per_page => 10
  end

  def new
    @order = Order.new

    respond_to do |format|
      format.html
      format.xml {render :xml => @order }
    end
  end

  def update

  end

  def create
    @order = Order.new(params[:order])
    @order.add_line_items_from_cart(current_cart)

    puts  @order.inspect
    respond_to do |format|
      if @order.save
        Cart.destroy(session[:cart_id])
        session[:cart_id] = nil
        Notifier.order_received(@order).deliver
        format.html { redirect_to(store_url, :notice => 'Thank you for your order!') }
        format.xml { render :xml => @order,  :status => :created, :location =>@order }
      else
        format.html {render :action => "new"}
        format.xml {render :xml => @order.errors, :status => :unprocessable_entity }
      end
    end
  end

  def destroy

  end
end