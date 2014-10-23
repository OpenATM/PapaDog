class CreateOrders < ActiveRecord::Migration
   def self.up
     create_table :orders do |t|
       t.string :name
       t.text :address
       t.string :email
       t.string :pay_type

       t.timestamps
     end

     def self.down
       drop_table :orders
     end
   end
end