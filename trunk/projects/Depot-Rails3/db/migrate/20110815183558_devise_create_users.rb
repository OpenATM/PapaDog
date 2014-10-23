class DeviseCreateUsers < ActiveRecord::Migration
  def self.up
    # rails admin / devise didn't see my existing users table... not sure if it should have
    # so we do some hackery here

    drop_table :users

    create_table(:users) do |t|
      t.string :name
      #t.database_authenticatable :null => false
      # t.string :email, :null => false, :default => ""
      # t.string :encrypted_password, :null => false, :default => ""
      # t.recoverable
      # t.rememberable
      # t.trackable

      ## Database authenticatable

      t.string :email,              :null => false, :default => ""
      t.string :encrypted_password, :null => false, :default => ""

      ## Recoverable
      t.string   :reset_password_token
      t.datetime :reset_password_sent_at

      ## Rememberable
      t.datetime :remember_created_at

      ## Trackable
      t.integer  :sign_in_count, :default => 0
      t.datetime :current_sign_in_at
      t.datetime :last_sign_in_at
      t.string   :current_sign_in_ip
      t.string   :last_sign_in_ip

      # t.encryptable
      # t.confirmable
      # t.lockable :lock_strategy => :failed_attempts, :unlock_strategy => :both
      # t.token_authenticatable


      t.timestamps
    end

    add_index :users, :email,                :unique => true
    add_index :users, :reset_password_token, :unique => true
    # add_index :users, :confirmation_token,   :unique => true
    # add_index :users, :unlock_token,         :unique => true
    # add_index :users, :authentication_token, :unique => true
  end

  def self.down
    drop_table :users
    # restore previous users table by copy/paste original
    # up migration code
    create_table :users do |t|
      t.string :name
      t.string :hashed_password
      t.string :salt

      t.timestamps
    end
  end
end
