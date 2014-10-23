class StudentsController < ApplicationController
  load_and_authorize_resource
  def new
    flash[:mynotice] = "123"
  	@student = Student.new(:username => "hj", :password => "123456")
  end
end
