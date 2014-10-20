TVServiceCodingExercise
=======================

Design and coding exercise in java


<h2>Scenario</h2>
<p>A TV broadcaster has decided to roll out 3D TV by geographic area. A software engineering team, developing the online store, is working on the story below.</p><br/>
<p>A “3D addon” is an enhancement to a customers existing Entertainment Pack. E.g. SPORTS_3D_ADD_ON enhances the SPORTS product.</p><br/>
<p>The broadcaster has partnered with a third party that provides a service that checks the 3D TV availability for a given postcode.</p><br/>

<h3>The following files are included</h3>
<ul>
<li>Basket.java</li>
<li>ThreeDeeAddOnService.java</li>
<li>AvailabilityChecker.java</li>
<li>TechnicalFailureException.java</li>
</ul>
<br/><br/>
<h2>Instructions</h2>
<p>You are required to provide an implementation of the ThreeDeeAddOnService interface, a simple service containing a single method.</p><br/>
<p>Basket and ThreeDeeAddOnService may be changed as you see fit.</p><br/><br/>
<p>The AvailabilityChecker and TechnicalFailureException cannot be modified.</p><br/><br/>

<h2>Requirements</h2><br/>
<p>The product codes for the entertainment packs are:</p><br/>
<ul>
<li>SPORTS</li>
<li>KIDS</li>
<li>VARIETY</li>
<li>NEWS</li>
<li>MOVIES_1</li>
<li>MOVIES_2</li>
</ul>
<br/>
<p>The product codes for the addon’s are:</p><br/>
<ul>
<li>SPORTS_3D_ADD_ON</li>
<li>NEWS_3D_ADD_ON</li>
<li>MOVIES_3D_ADD_ON</li>
</ul>
<br/>
The third party service returns the following values:
SERVICE_AVAILABLE 3DTV service is available for the given post code
SERVICE_UNAVAILABLE 3DTV service is unavailable for the given post code
SERVICE_PLANNED 3DTV service is not available right now, but it should be available
within the next 3 months
POSTCODE_INVALID The supplied postcode is invalid
If the service is unavailable then a TechnicalFailureException is thrown.
Acceptance Criteria
Postcode Basket Expected Output
Currently in a
3D area
3D compatible
products in the
basket
Return relevant 3D addons
N/A No products
with 3D addons
Return no 3D addons
Currently,
not in a 3D
area, or
technical
failure occurs
3D compatible
products in the
basket
Return no 3D addons
Invalid
postcode
3D compatible
products in the
basket
Return no 3D addons
and
notify the client that the
postcode was invalid
You may choose any means of accepting input and producing output, including the use of a test
harness.
Try and spend no more than two hours on this problem.
