package helloworld

class BootStrap {

    def init = { servletContext ->
    HelloWord hw = new HelloWord (theWord:"hello")
    hw.save()

    HelloWord hw2 = new HelloWord (theWord:"World")
    hw2.save()

    }
    def destroy = {
    }
}
