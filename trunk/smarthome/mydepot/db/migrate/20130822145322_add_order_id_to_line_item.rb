class AddOrderIdToLineItem < ActiveRecord::Migration
  def self.up
    add_column :line_items, :order_id, :integer
  end
  # To change this template use File | Settings | File Templates.
  def self.down
    remove_column :line_items, :order_id
  end
end