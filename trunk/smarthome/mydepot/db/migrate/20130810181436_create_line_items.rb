class CreateLineItems < ActiveRecord::Migration
   def self.up
     create_table :line_items do |t|
       t.integer :product_id
       t.integer :cart_id

       t.timestamps
     end

     def self.down
       drop_table :orders
     end
   end
end