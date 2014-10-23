class ProductsController < ApplicationController
  def show
    @product = Product.find(params[:id])

    respond_to do |format|
      format.html
      format.xml {render :xml => @product}
    end
  end

  def new
    @product = Product.new
    respond_to do |format|
      format.html
      format.xml {render :xml => @product}
    end
  end

  def edit
    @product = Product.find(params[:id])
  end

  def create
    #puts "params****************#{params[:product]}"
    @product = Product.new(params[:product])
    respond_to do |format|
      ret = @product.save
      puts "ret1:#{ret}"
      if ret
        format.html {redirect_to(@product, :notice => "Product was successfully created.")}
   #     format.html{redirect_to "http://www.baidu.com/"}
       format.xml {render :xml => @product, :status => :created, :location =>  @product }
      else
        format.html {render :action => "new"}
        format.xml {render :xml => @product.errors, :status => :unprocessable_entity }
      end
    end
  end

  def update
    @product = Product.find(params[:id])

    respond_to do |format|
      if @product.update_attributes(params[:product])
        format.html {redirect_to(@product, :notice => 'Product was successfully updated')}
        format.xml {head :ok}
      else
        format.html {render :action => "edit"}
        format.xml  {render :xml => @product.errors, :status => :unprocessable_entity }
      end
    end
  end

  def destroy
    @product = Product.find(params[:id])
    @product.active = false
    @product.save!

    respond_to do |format|
      format.html {redirect_to(products_url)}
      format.xml {head  :ok}
    end
  end

  def index
    @products = Product.all_active
    @inactive_products = Product.all_inactive

    respond_to do |format|
      format.html
      format.xml {render :xml => @products}
    end
  end
end