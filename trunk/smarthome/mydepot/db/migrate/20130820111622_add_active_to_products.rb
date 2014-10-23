class AddActiveToProducts < ActiveRecord::Migration
  def self.up
    add_column :products, :active, :boolean, :default => true
  end
  # To change this template use File | Settings | File Templates.
  def self.down
    remove_column :products, :active, :boolean
  end
end
