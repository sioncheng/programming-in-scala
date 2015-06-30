import org.scalatest.Suite
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MyTestSuite extends Suite {
	def testMethod() {
		assert(2==2)
	}
}

class MySpec extends FlatSpec with ShouldMatchers {
	"1" should "be 1" in {
		1 should be (1)
	}

	it should "'a' is 'a'" in {
		'a' should be ('a')
	}
}

(new MyTestSuite()).execute()
(new MySpec()).execute()

assert(1==1)

