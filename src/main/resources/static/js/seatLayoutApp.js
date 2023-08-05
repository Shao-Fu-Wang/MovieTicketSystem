//<!-- Include FileSaver.js -->

$(document).ready(function () {
  function loadGrid() {
    fetch('/json/layoutData.json')
      .then((response) => response.json())
      .then(async (seatData) => {
        var occupiedSeatList = await fetchOccupiedSeat();
//        console.log(occupiedSeatList)
        seatData = await mapOccupiedSeatJson(seatData, occupiedSeatList);
        // continue with rendering the seat layout
        var numberOfSeat = $('.numberOfSeat').val();
        $('.selectMove').seatLayout({
          data: seatData,
          showActionButtons: true,
          classes: {
            doneBtn: '',
            row: '',
            area: '',
            screen: '',
            seat: ''
          },
          numberOfSeat: numberOfSeat,
          callOnSeatRender: function (Obj) {
            //modify seat object if require and return it;
            return Obj;
          },
          callOnSeatSelect: function (_event, _data, _selected, _element) {
            console.log(_event);
            console.log(_data);
            console.log(_selected);
          },
          selectionDone: function (_array) {
            console.log(_array);
          },
        });
      })
      .catch((error) => {
        // handle any errors that occur during the request
        console.error(error);
      });
  }

  loadGrid();

  $('.call-load-function').click(function () {
    loadGrid();
  });
});

function fetchOccupiedSeat() {
  return fetch('/seat/occupied')
    .then(response => response.json());
}

function mapOccupiedSeatJson(seatData, occupiedSeatList){
    console.log(seatData);
    console.log(occupiedSeatList);
      for (const occupiedSeat of occupiedSeatList) {
        const area = seatData.seatLayout.colAreas.objArea.find(area =>
          area.objRow.some(row =>
            row.objSeat.some(s =>
              s.seatNumber === occupiedSeat.occupiedSeatNumber && row.PhyRowId === occupiedSeat.occupiedSeatPhyRowId
            )
          )
        );

        if (area) {
          const seatToUpdate = area.objRow.find(row =>
            row.PhyRowId === occupiedSeat.occupiedSeatPhyRowId
          ).objSeat.find(s => s.seatNumber === occupiedSeat.occupiedSeatNumber);

          if (seatToUpdate) {
            seatToUpdate.SeatStatus = "1";
          }
        }
      }

      return seatData;
}
