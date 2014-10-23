class Student < ActiveRecord::Base
  # attr_accessible :title, :body
   attr_accessible :username, :password, :teacher_idl
   belongs_to :teacher #

  # accepts_nested_attributes_for  :teacher
end
