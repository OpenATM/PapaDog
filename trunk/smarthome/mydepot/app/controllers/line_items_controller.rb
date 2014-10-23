class LineItemsController < ApplicationController

  def index
  end

  def new

  end

  def update

  end

  def create
    @cart = current_cart
    product = Product.find(params[:product_id])
    @line_item = @cart.add_product(product.id)

    respond_to do |format|
      if @line_item.save
        puts "strore_url:#{store_url}"
        puts "save successful********************"
        format.html { raise "ha ah *****";redirect_to(store_url) }
        format.js { @current_item = @line_item}
        format.xml { render :xml => @line_item, :status => :created, :location => @line_item}
      else
        puts "save failed********************"
        format.html { render :action => "new"}
        format.xml { render :xml => @line_item.errors, :status => :unprocessable_entity}
      end
    end
    # respond_to do |format|
    #   format.js
    # end
  end

  def destroy

  end

  def test
  end
end