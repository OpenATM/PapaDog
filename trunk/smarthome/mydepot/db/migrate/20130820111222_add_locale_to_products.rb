class AddLocaleToProducts < ActiveRecord::Migration
  def self.up
    add_column :products, :locale, :string, :default => 'en'
  end
  # To change this template use File | Settings | File Templates.
  def self.down
    remove_column :products, :locale
  end
end