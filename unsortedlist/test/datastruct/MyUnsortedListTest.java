package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnsortedListTest {
	
	/*------------------------------------------------------------------------*/
	/*------------------------EQUALS()----------------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testEqualsNotList(){
		// Tests equals on 2 differents types (list/not list)
		UnsortedList<Integer> integersEqualsInteger = MyUnsortedList.of(1,2,3,4);
		assertEquals(false,integersEqualsInteger.equals(1));
	}
	
	@Test
	public void testEqualsNotSametype(){
		// Tests equals on 2 differents types (both list)
		UnsortedList<Integer> integersEqualsInteger = MyUnsortedList.of(1,2,3,4);
		UnsortedList<String> integersEqualsString = MyUnsortedList.of("a","b","c");
		assertEquals(false,integersEqualsInteger.equals(integersEqualsString));
	}
	
	@Test
	public void testEqualsEmpty(){
		// Tests equals on 2 UnsortedList<Integer>, one empty, the other not
		UnsortedList<Integer> integersEqualsInteger = MyUnsortedList.of(1);
		UnsortedList<Integer> integersEqualsString = MyUnsortedList.of();
		integersEqualsString.insert(null, 0);
		assertEquals(false,integersEqualsInteger.equals(integersEqualsString));
	}
	
	@Test
	public void testEqualsNull(){
		// Tests equals on 2 UnsortedList initialy empty, adding a null head and a non-null head.
		UnsortedList<Integer> integersEqualsInteger = MyUnsortedList.of();
		integersEqualsInteger.insert(null, 0);
		UnsortedList<String> integersEqualsString = MyUnsortedList.of();
		integersEqualsString.insert("a", 0);
		assertEquals(false,integersEqualsInteger.equals(integersEqualsString));
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------isEMPTY()---------------------------------------*/
	/*------------------------------------------------------------------------*/
		
	@Test
	public void testIsEmptyOnNonEmpty() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
		assertFalse(integers.isEmpty());
	}
	@Test
	public void testIsEmptyOnEmpty() {
		UnsortedList<Integer> integers2 = MyUnsortedList.of();
		assertTrue(integers2.isEmpty());
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------SIZE()------------------------------------------*/
	/*------------------------------------------------------------------------*/

	@Test
	public void testSizeNoZero() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1, 2, 3, 4);
		assertEquals(4,integers.size());
	}
	@Test
	public void testSizeZero() {	
		UnsortedList<Integer> integers2 = MyUnsortedList.of();
		assertEquals(0,integers2.size());
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------PREPEND()---------------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testPrependOnNonEmpty() {
		UnsortedList<Integer> integersNonEmpty1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersNonEmpty2 = MyUnsortedList.of(4, 1, 2, 3, 4);
		integersNonEmpty1.prepend(4);
		assertEquals(5,integersNonEmpty1.size());
		assertEquals(integersNonEmpty2,integersNonEmpty1);
	}
	@Test
	public void testPrependOnEmpty() {
		UnsortedList<Integer> integersEmpty1 = MyUnsortedList.of();
		UnsortedList<Integer> integersEmpty2 = MyUnsortedList.of(4);
		integersEmpty1.prepend(4);
		assertEquals(1,integersEmpty1.size());
		assertEquals(integersEmpty2,integersEmpty1);
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------APPEND()----------------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testAppendOnNonEmpty() {
		UnsortedList<Integer> integersNonEmpty1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersNonEmpty2 = MyUnsortedList.of(1, 2, 3, 4, 5);
		integersNonEmpty1.append(5);
		assertEquals(5, integersNonEmpty1.size());
		assertEquals(integersNonEmpty2,integersNonEmpty1);
	}
	@Test
	public void testAppendOnEmpty() {
		UnsortedList<Integer> integersEmpty1 = MyUnsortedList.of();
		UnsortedList<Integer> integersEmpty2 = MyUnsortedList.of(5);
		integersEmpty1.append(5);
		assertEquals(1, integersEmpty1.size());
		assertEquals(integersEmpty2,integersEmpty1);
	}
	
	/*------------------------INSERT()----------------------------------------*/
	/*-----------------NON EMPTY LISTS----------------------------------------*/
	/*------------------------------------------------------------------------*/
	@Test
	public void testInsertLast() {
		/* --- on lists non empty ---- */
		// at last position
		UnsortedList<Integer> integersNonEmptyInsertLast1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersNonEmptyInsertLast2 = MyUnsortedList.of(1, 2, 3, 4, 5);
		integersNonEmptyInsertLast1.insert(5, integersNonEmptyInsertLast1.size());
		assertEquals(5, integersNonEmptyInsertLast1.size());
		assertEquals(integersNonEmptyInsertLast2,integersNonEmptyInsertLast1);
	}
	@Test
	public void testInsertFirst() {
		/* --- on lists non empty ---- */
		//at first position
		UnsortedList<Integer> integersNonEmptyInsertFirst1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersNonEmptyInsertFirst2 = MyUnsortedList.of(5,1, 2, 3, 4);
		integersNonEmptyInsertFirst1.insert(5, 0);
		assertEquals(5, integersNonEmptyInsertFirst1.size());
		assertEquals(integersNonEmptyInsertFirst2,integersNonEmptyInsertFirst1);
	}	
	@Test
	public void testInsertIn() {
		/* --- on lists non empty ---- */
		// into the list at a given position
		UnsortedList<Integer> integersNonEmptyInsert1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersNonEmptyInsert2 = MyUnsortedList.of(1, 5, 2, 3, 4);
		integersNonEmptyInsert1.insert(5, 1);
		assertEquals(5, integersNonEmptyInsert1.size());
		assertEquals(integersNonEmptyInsert2,integersNonEmptyInsert1);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertTooHigh() throws Exception{
		/* --- on lists non empty ---- */
		// throws exception : invalid position (too high)
		UnsortedList<Integer> integersInsertTooHigh = MyUnsortedList.of(1, 2, 3, 4);
		integersInsertTooHigh.insert(5, integersInsertTooHigh.size() + 1);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertTooLow() throws Exception{
		/* --- on lists non empty ---- */
		// throws exception : invalid position (too low)
		UnsortedList<Integer> integersInsertTooLow = MyUnsortedList.of(1, 2, 3, 4);
		integersInsertTooLow.insert(5, -1);		
	}
	
	/*------------------------INSERT()----------------------------------------*/
	/*---------------------EMPTY LISTS----------------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testInsertOnEmpty() {
		/* --- on lists empty ---- */
		UnsortedList<Integer> integersEmptyInsert1 = MyUnsortedList.of();
		UnsortedList<Integer> integersEmptyInsert2 = MyUnsortedList.of(5);
		integersEmptyInsert1.insert(5, integersEmptyInsert1.size());
		assertEquals(1, integersEmptyInsert1.size());
		assertEquals(integersEmptyInsert2,integersEmptyInsert1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertEmptyTooHigh() throws Exception{
		/* --- on lists empty ---- */
		// throws exception : invalid position (too high)
		UnsortedList<Integer> integersInsertEmptyTooHigh = MyUnsortedList.of();
		integersInsertEmptyTooHigh.insert(5, integersInsertEmptyTooHigh.size() + 1);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertEmptyTooLow() throws Exception{
		/* --- on lists empty ---- */
		// throws exception : invalid position (too low)
		UnsortedList<Integer> integersInsertEmptyTooLow = MyUnsortedList.of();
		integersInsertEmptyTooLow.insert(5, -1);		
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------------POP()-------------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testPopOnNonEmpty() {
		/* --- on lists non empty ---- */
		UnsortedList<Integer> integersPop1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersPop2 = MyUnsortedList.of(2, 3, 4);
		Integer first = integersPop1.pop();
		assertEquals(Integer.valueOf(1), first);
		assertEquals(integersPop2,integersPop1);
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopOnEmpty() throws Exception{
		/* --- on lists empty ---- */
		// throws exception : can't pop from an empty list
		UnsortedList<Integer> integersPopEmpty = MyUnsortedList.of();
		integersPopEmpty.pop();		
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------------POP LAST()--------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testPopLastOnNonEmpty() {
		/* --- on lists non empty ---- */
		UnsortedList<Integer> integersPopLast1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersPopLast2 = MyUnsortedList.of(1, 2, 3);
		Integer last = integersPopLast1.popLast();
		assertEquals(Integer.valueOf(4), last);
		assertEquals(integersPopLast2,integersPopLast1);
	}
		
	@Test(expected = EmptyListException.class)
	public void testPopLastOnEmpty() throws Exception{
		/* --- on lists empty ---- */
		// throws exception : can't pop from an empty list
		UnsortedList<Integer> integersPopEmpty = MyUnsortedList.of();
		integersPopEmpty.popLast();		
	}
	
	/*------------------------------------------------------------------------*/
	/*------------------------------REMOVE()----------------------------------*/
	/*------------------------------------------------------------------------*/
	
	@Test
	public void testRemoveLastNonEmpty() {
		/* --- on lists non empty ---- */
		// last position
		UnsortedList<Integer> integersRemoveLast1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersRemoveLast2 = MyUnsortedList.of(1, 2, 3);
		Integer last = integersRemoveLast1.remove(integersRemoveLast1.size()-1);
		assertEquals(Integer.valueOf(4), last);
		assertEquals(integersRemoveLast2,integersRemoveLast1);
	}
	
	@Test
	public void testRemoveFirstNonEmpty() {
		/* --- on lists non empty ---- */
		// first position
		UnsortedList<Integer> integersRemoveFirst1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersRemoveFirst2 = MyUnsortedList.of(2, 3, 4 );
		Integer first = integersRemoveFirst1.remove(0);
		assertEquals(Integer.valueOf(1), first);
		assertEquals(integersRemoveFirst2,integersRemoveFirst1);
	}
	
	@Test
	public void testRemoveGivenPositionNonEmpty() {
		/* --- on lists non empty ---- */
		// given position
		UnsortedList<Integer> integersRemoveGivenPosition1 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> integersRemoveGivenPosition2 = MyUnsortedList.of(1, 2, 4);
		Integer first = integersRemoveGivenPosition1.remove(2);
		assertEquals(Integer.valueOf(3), first);
		assertEquals(integersRemoveGivenPosition2,integersRemoveGivenPosition1);
		assertEquals(integersRemoveGivenPosition2.toString(),integersRemoveGivenPosition1.toString());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveEmpty() throws Exception{
		/* --- on lists empty ---- */
		// throws exception : can't remove from an empty list
		UnsortedList<Integer> integersRemoveEmpty = MyUnsortedList.of();
		integersRemoveEmpty.remove(0);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveTooHigh() throws Exception{
		// throws exception : can't remove above size - 1
		UnsortedList<Integer> integersRemoveTooHigh = MyUnsortedList.of(1,2,3,4);
		integersRemoveTooHigh.remove(4);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveTooLow() throws Exception{
		// throws exception : can't remove under 0
		UnsortedList<Integer> integersRemoveTooLow = MyUnsortedList.of(1,2,3,4);
		integersRemoveTooLow.remove(-1);		
	}
	
}
