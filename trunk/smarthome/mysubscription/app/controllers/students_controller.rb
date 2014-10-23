class StudentsController < ApplicationController
  def new
    @student =   Student.new
    respond_to do |format|
      format.html
    end
  end
  def create
    puts "teacher:#{params[:student][:teacher_id]}"
    @teacher = Teacher.find(params[:student][:teacher_id])
    #@student = Student.new(params[:student])
    @teacher.students.create(params[:student])
    #@student.teacher = @teacher
    #@student = Student.new
     #@student = @student.build(params[:student])
     respond_to do |format|
       if @student.save
         format.html
         #
       else
         flash[:error] = "save students unsuccessful"
         format.html { render :action => "new"}
       end
     end

  end
end
