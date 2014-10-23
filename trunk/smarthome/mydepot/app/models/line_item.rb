class LineItem < ActiveRecord::Base
  belongs_to :order
  belongs_to :product
  belongs_to :cart

  attr_accessible :product_id, :cart_id

  def total_price
    price * quantity
  end
end
