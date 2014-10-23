class AddQuantityToLineItem < ActiveRecord::Migration
  def self.up
    add_column :line_items, :quantity, :integer, :default => 1
  end
  # To change this template use File | Settings | File Templates.
  def self.down
    remove_column :line_items, :quantity
  end
end