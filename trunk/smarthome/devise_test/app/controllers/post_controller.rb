class PostController < ApplicationController
  def read
    logger.info "start to read................................................"
    post = Post.new
    #post.save
    @mypost = Post.find(1)
    logger.info "post:#{@mypost}"
    #authorize! :read, @mypost
    render 'post/mypost'
  end
end
