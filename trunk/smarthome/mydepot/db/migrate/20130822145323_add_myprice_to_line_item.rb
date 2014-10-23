class AddMypriceToLineItem < ActiveRecord::Migration
  def self.up
    add_column :line_items, :price, :decimal, :precision => 8, :scale => 2, :default => 0.0

    LineItem.all.each do |line_item|
      line_item.price = Product.find(line_item.product_id).price
      line_item.save
    end
  end
  # To change this template use File | Settings | File Templates.
  def self.down
    remove_column :line_items, :price
  end
end